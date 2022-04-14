FROM centos:7

# system update
RUN yum -y update && yum install -y vim tcpdump telnet iptables net-tools wget git && yum clean all
WORKDIR /u01
RUN wget https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-22.0.0.2/graalvm-ce-java11-linux-amd64-22.0.0.2.tar.gz && tar zxvf graalvm-ce-java11-linux-amd64-22.0.0.2.tar.gz && rm graalvm-ce-java11-linux-amd64-22.0.0.2.tar.gz && mv graalvm-ce-java11-22.0.0.2 graalvm-ce-java11

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["/u01/graalvm-ce-java11/bin/java","-jar","/u01/app.jar"]

