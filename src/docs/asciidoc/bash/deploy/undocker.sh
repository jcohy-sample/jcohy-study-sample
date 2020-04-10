#!/bin/bash
# tag::code[]
# 定义颜色
BLUE_COLOR="\033[36m"
RES="\033[0m"

# 部署项目
echo -e "${BLUE_COLOR}===================> remove docker-compose start <==================${RES}"
rm -rf /usr/local/bin/docker-compose
echo -e "${BLUE_COLOR}===================> remove docker-compose end <====================${RES}"

echo -e "${BLUE_COLOR}===================> remove docker-ce start <=======================${RES}"
echo -e "${BLUE_COLOR}===================> 1、stop,rm,rmi docker <========================${RES}"
docker stop $(docker ps -q) && docker rm $(docker ps -aq) && docker rmi $(docker images -q)
echo -e "${BLUE_COLOR}===================> 2、stop docker-ce <============================${RES}"
systemctl stop docker
echo -e "${BLUE_COLOR}===================> 3、disable docker-ce <=========================${RES}"
systemctl disable docker
echo -e "${BLUE_COLOR}===================> 4、remove docker-ce <==========================${RES}"
yum remove -y docker-ce
echo -e "${BLUE_COLOR}===================> 5、remove docker-ce Dependency <===============${RES}"
yum list installed|grep docker|awk '{print $1}'|xargs yum remove -y
echo -e "${BLUE_COLOR}===================> 6、delete config dir <=========================${RES}"
rm -rf /etc/docker
echo -e "${BLUE_COLOR}===================> 7、delete data dir <===========================${RES}"
rm -rf /var/lib/docker
rm -rf /usr/local/docker
echo -e "${BLUE_COLOR}===================> remove docker-ce end <=========================${RES}"
# end::code[]