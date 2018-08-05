#!/usr/bin/env python3
# -*- coding: utf-8 -*-


import socket
from threading import Thread

HOST = 'localhost'
PORT = 9009


def recevie_msg(sock):
   while True:
      try:
         data = sock.recv(1024)
         if not data:
            break
         print(data.decode())
      except:
         pass


def run_chat():
   with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
      sock.connect((HOST, PORT))
      t = Thread(target=recevie_msg, args=(sock,))
      t.daemon = True
      t.start()

      while True:
         msg = input()
         if msg == '/quit':
            sock.send(msg.encode())
            break

         sock.send(msg.encode())
            
run_chat()
