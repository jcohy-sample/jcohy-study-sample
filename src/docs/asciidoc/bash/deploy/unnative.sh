#!/bin/bash
# tag::code[]
# 定义颜色
BLUE_COLOR="\033[36m"
RES="\033[0m"

usage(){
	echo -e "${BLUE_COLOR}卸载 jdk，请执行  source ./unnative.sh jdk${RES}"
	echo -e "${BLUE_COLOR}卸载 tomcat，请执行  ./unnative.sh tomcat${RES}"
	echo -e "${BLUE_COLOR}卸载 mysql，请执行  ./unnative.sh mysql${RES}"
	echo -e "${BLUE_COLOR}卸载 nginx，请执行  ./unnative.sh nginx${RES}"
	echo -e "${BLUE_COLOR}卸载，请执行  ./unnative.sh all${RES}"
	exit 1
}

jdk(){
	echo -e "${BLUE_COLOR}正在卸载 jdk.${RES}"
	rm -rf /usr/local/jdk1.8.0_221
	sed -i '\/usr\/local\/jdk1.8.0_221/d' /etc/profile
	sed -i '/\$JAVA_HOME\/bin/d' /etc/profile
	echo -e "${BLUE_COLOR}jdk  卸载完成${RES}"
}

tomcat(){
	echo -e "${BLUE_COLOR}正在卸载 tomcat.${RES}"
	/usr/local/apache-tomcat-7.0.94/bin/shutdown.sh
	sleep 2
	rm -rf /usr/local/apache-tomcat-7.0.94
	port 8080
	echo -e "${BLUE_COLOR}tomcat卸载完成${RES}"
}

mysql(){
	echo -e "${BLUE_COLOR}正在卸载 mysql${RES}"
	rpm -e mysql-community-server-8.0.19-1.el7.x86_64
	rpm -e mysql-community-client-8.0.19-1.el7.x86_64
	rpm -e mysql-community-libs-8.0.19-1.el7.x86_64
	rpm -e mysql-community-common-8.0.19-1.el7.x86_64
	   
	   
	#groupdel mysql
	userdel mysql

	rm -rf /var/lib/mysql
	rm -rf /var/lib/mysql/mysql
	rm -rf /var/log/mysqld.log
	port 3306
	echo -e "${BLUE_COLOR}mysql卸载完成${RES}"
}

nginx(){
	echo -e "${BLUE_COLOR}正在卸载 nginx${RES}"
	/usr/local/nginx/sbin/nginx -s stop
	sleep 2
	rm -rf /usr/local/nginx
	port 80
	port 443
	echo -e "${BLUE_COLOR}nginx  卸载完成 ${RES}"
}

port(){
	echo -e "${BLUE_COLOR}移除 $1 端口访问${RES}"
	
	firewall-cmd --zone=public --remove-port=$1/tcp --permanent
	firewall-cmd --reload
}

case "$1" in
"jdk")
	jdk
;;
"tomcat")
	tomcat
;;
"nginx")
	nginx
;;
"mysql")
	mysql
;;
"all")
	tomcat
	nginx
	mysql
	jdk
;;
*)
	usage
;;
esac
# end::code[]