#!/usr/bin/env python3
# -*- coding: utf-8 -*-


import socketserver
import threading

HOST = ''
PORT = 9009
lock = threading.Lock()


class UserManager:
   def __init__(self):
      self.users = {}

   def add_user(self, username, conn, addr):
      if username in self.users:
         conn.send('이미 등록된 사용자입니다.\n'.encode())
         return None

      # 새로운 사용자를 등록함
      lock.acquire()
      self.users[username] = (conn, addr)
      lock.release()

      self.send_message_to_all('[%s]님이 입장했습니다.' % username)
      print('+++ 대화 참여자 수 [%d]' %len(self.users))
        
      return username

   def remove_user(self, username):
      if username not in self.users:
         return

      lock.acquire()
      del self.users[username]
      lock.release()

      self.send_message_to_all('[%s]님이 퇴장했습니다.' % username)
      print('--- 대화 참여자 수 [%d]' %len(self.users))

   def message_handler(self, username, msg):
      if msg[0] != '/':
         self.send_message_to_all('[%s] %s' % (username, msg))
         return

      if msg.strip() == '/quit':
         self.remove_user(username)
         return -1

   def send_message_to_all(self, msg):
      for conn, addr in self.users.values():
         conn.send(msg.encode())
          

class MyTcpHandler(socketserver.BaseRequestHandler):
   userman = UserManager()
    
   def handle(self):        
      print('[%s] 연결됨' %self.client_address[0])

      try:
         username = self.register_username()
         msg = self.request.recv(1024)
         while msg:
            print(msg.decode())
            if self.userman.message_handler(username, msg.decode()) == -1:
               self.request.close()
               break
            msg = self.request.recv(1024)
                
      except Exception as e:
         print(e)

      print('[%s] 접속종료' %self.client_address[0])
      self.userman.remove_user(username)

   def register_username(self):
      while True:
         self.request.send('로그인ID:'.encode())
         username = self.request.recv(1024)
         username = username.decode().strip()
         if self.userman.add_user(username, self.request, self.client_address):
            return username


class ChatingServer(socketserver.ThreadingMixIn, socketserver.TCPServer):
    pass


def run_server():
   print('+++ 채팅 서버를 시작합니다.')
   print('+++ 채텅 서버를 끝내려면 Ctrl-C를 누르세요.')

   try:
      server = ChatingServer((HOST, PORT), MyTcpHandler)
      server.serve_forever()
   except KeyboardInterrupt:
      print('--- 채팅 서버를 종료합니다.')
      server.shutdown()
      server.server_close()

run_server()
