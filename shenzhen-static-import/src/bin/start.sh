export JAVA_HOME=/usr/lib/jvm/java-8-oracle
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH
#获取配置文件名称
#confName=`pwd|cut -d / -f 5`
confName=ifaas

#nohup java -XX:+UseConcMarkSweepGC -Xmx4096m -Xms4096m  -XX:+PrintGCDateStamps -XX:+PrintGCDetails  -Xloggc:./logs/java_gc.log  -XX:-HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./logs/ -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8 -jar  dataImport.jar --spring.profiles.active=${confName} --isJar=true > nohup.out &
nohup java -XX:+UseConcMarkSweepGC -Xmx4192m -Xms4192m -Xss256k  -XX:+PrintGCDateStamps -XX:+PrintGCDetails  -Xloggc:./logs/java_gc.log  -XX:-HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./logs/ -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8  -jar  dataImport.jar --spring.profiles.active=${confName} --isJar=true > /dev/null 2>&1 &
