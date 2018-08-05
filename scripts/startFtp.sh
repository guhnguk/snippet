#!/usr/bin/env bash

# Read Me
# Ftp Configuration file is /etc/ftpd.conf

if [ "$1" = "start" ]
then
	echo "FTP server started ..."
	sudo -s launchctl load -w /System/Library/LaunchDaemons/ftp.plist
	echo "Welcom to AhnsMacBookPro.local"
elif [ "$1" = "stop" ]
then
	echo "FTP server stopped ..."
	sudo -s launchctl unload -w /System/Library/LaunchDaemons/ftp.plist
	echo "Bye ~"
else 
	echo "Usage: startFtp.sh <start|stop>"
fi
