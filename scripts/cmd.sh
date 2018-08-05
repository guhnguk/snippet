!/bin/bash +x

expected_args=3
if [ $# -ne $expected_args ]
then
echo "usage: $0  startno endno cmd"
exit
fi

prefix='203.235.211.'
for i in $(seq  $1 $2) #for linux
#for i in $(jot - $1 $2) #for mac
do
echo "ssh  $prefix$i $3"
ssh  root@$prefix$i $3
done
