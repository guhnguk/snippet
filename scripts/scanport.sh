#!/usr/bin/env bash

# -----------------------------------------------------------------------------
#
# 실행 방법
# (1) 반드시 동일 디렉토리에 "checkport.env"이 있어야 한다.
#  만약 경로를 변경 하려고 하면  "LINES"에서 경로를 수정 한다.
#
#  (2) 구분자를 변경하고 싶을 경우 "PARSE_CHAR"를 변경하고
#  "checkport.env" 파일의 구분자를 변경 한다.
#
#  (3) 별다른 파라미터 설정 없이 "./scanport.sh"를 실행 한다.
# -----------------------------------------------------------------------------

PARSE_CHAR=":"
REQ_TIMEOUT=10
LINES="$(awk '/^[a-zA-Z1-9]/ {print}' ./checkport.env)"
RESULT

set LINE_ARRAY
echo "- server port scanning............................"
for i in $LINES
do
	LINE_ARRAY="$(echo $i | sed -e 's/'$PARSE_CHAR'/ /g')"
    LINE_ARRAY=($LINE_ARRAY)
    RESULT="$(nc -z -w $REQ_TIMEOUT  ${LINE_ARRAY[1]} ${LINE_ARRAY[2]})"

    if [ "$?" -ne 0 ]; then
    	echo "*Connection to ${LINE_ARRAY[0]}  on port
	    ${LINE_ARRAY[1]}:${LINE_ARRAY[2]}  failed"
    else
        echo "Connection to ${LINE_ARRAY[0]}  on port
	    ${LINE_ARRAY[1]}:${LINE_ARRAY[2]}  succeeded"
    fi

    sleep 1
done

exit 0
