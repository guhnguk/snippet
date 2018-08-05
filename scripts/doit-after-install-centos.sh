#!/usr/bin/env bash

# after installing centos, which has a minimum desktop

yum -y upgrade

yum -y install wget
yum -y install setuptool
yum -y install ntsysv
yum -y install system-config-network system-config-network-tui
yum -y install ipvsadm
yum -y install mc
yum -y install openssh*
yum -y libaio

yum groupinstall -y "Development tools"

yum install -y zlib-devel bzip2-devel openssl-devel ncurses-devel \
sqlite-devel readline-devel tk-devel gdbm-devel db4-devel libpcap-devel xz-devel

service iptables stop

service NetworkManager stop
chkconfig NetworkManager off
