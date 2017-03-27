
#!/bin/bash

mycp=classes
mkdir $mycp

javac -d $mycp MinHeap.java DemoMain.java
ret=$?

if [ $ret -ne 0 ] ; then
	echo "Compile failed."
	exit 255
fi

java -classpath $mycp DemoMain

exit 0
