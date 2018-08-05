#!/usr/bin/env python

# simple check
lspci | grep -i vga


# do as sudo    
lspci  -v -s  $(lspci | grep ' VGA ' | cut -d" " -f 1)

 

