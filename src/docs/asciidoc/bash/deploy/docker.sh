#!/bin/bash
# tag::code[]
# 定义颜色

BLUE_COLOR="\033[36m"
RED_COLOR="\033[31m"
GREEN_COLOR="\033[32m"
RES="\033[0m"

#软件安装目录
DOCKER_DIR=/usr/local/docker

BASH_CONFIG=http://software.jcohy.com/bash/common
#使用说明,用来提示输入参数
usage() {
	echo -e "${BLUE_COLOR}安装 elk 之前,请确保vm.max_map_count大小至少为 262144.执行${RES}"
	echo -e "${BLUE_COLOR}安装 nacos,请执行  source ./docker.sh nacos${RES}"
	echo -e "${BLUE_COLOR}安装 sentinel,请执行  ./docker.sh sentinel${RES}"
	echo -e "${BLUE_COLOR}安装 api-nginx,请执行  ./docker.sh api-nginx${RES}"
	echo -e "${BLUE_COLOR}安装 web-nginx,请执行  ./docker.sh web-nginx${RES}"
	echo -e "${BLUE_COLOR}安装 redis-master,请执行  ./docker.sh redis${RES}"
	echo -e "${BLUE_COLOR}安装 rabbitmq,请执行  ./docker.sh rabbitmq${RES}"
	echo -e "${BLUE_COLOR}安装 zipkin,请执行  ./docker.sh zipkin${RES}"
	echo -e "${BLUE_COLOR}安装 minio,请执行  ./docker.sh minio${RES}"
	echo -e "${BLUE_COLOR}安装 elk,请执行  ./docker.sh elk${RES}"
	echo -e "${BLUE_COLOR}启动基础模块,请执行  ./docker.sh base${RES}"
	echo -e "${BLUE_COLOR}关闭所有模块,请执行  ./docker.sh stop${RES}"
	echo -e "${BLUE_COLOR}删除所有模块,请执行  ./docker.sh rm${RES}"
	echo -e "${BLUE_COLOR}删除Tag为空的镜像,请执行  ./docker.sh rmiNoneTag${RES}"
	exit 1
}



echo -e "${RED_COLOR}>>>>>>>>>>>>>>>>>>>>>>>>>> Init The Start <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<${RES}"
# 安装docker
if ! [ -x "$(command -v docker)" ]; then
   echo -e "${GREEN_COLOR}---------->>检测到 Docker 尚未安装.正在试图从网络安装...所需时间与你的网络环境有关${RES}"
   echo -e "${GREEN_COLOR}---------->>安装一些必要的系统工具${RES}"
   yum install -y yum-utils device-mapper-persistent-data lvm2 bridge-utils net-tools
   echo -e "${GREEN_COLOR}---------->>添加软件源信息${RES}"
   yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
   yum makecache fast
   yum -y install docker-ce
  echo -e "${GREEN_COLOR}---------->>添加docker镜像仓库${RES}"
   mkdir -p /etc/docker
   
   tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://iip73wnl.mirror.aliyuncs.com"],
  "insecure-registries":["192.168.11.239"] 
}
EOF

   systemctl daemon-reload
   systemctl start docker
   systemctl enable docker
   if ! [ -x "$(command -v docker)" ]; then
	echo -e "${RED_COLOR}Docker 自动安装失败,建议你手动安装好 docker 环境后再启动本脚本${RES}"
	exit 1
   fi
   echo -e "${GREEN_COLOR}---------->> docker 安装成功!${RES}"
fi


#安装docker-compose

if ! [ -x "$(command -v docker-compose)" ]; then
	echo -e "${GREEN_COLOR}---------->>开始安装 docker-compose${RES}"
	echo -e "${GREEN_COLOR}---------->>检测到 docker-compose 尚未安装.正在试图从网络安装...所需时间与你的网络环境有关${RES}"
	curl -L https://dn-dao-github-mirror.daocloud.io/docker/compose/releases/download/1.23.1/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
	chmod +x /usr/local/bin/docker-compose
	if ! [ -x "$(command -v docker-compose)" ]; then
		echo -e "${RED_COLOR}docker-compose 自动安装失败,建议你手动安装好 docker-compose 环境后再启动本脚本${RES}"
		exit 1
	fi
	echo -e "${GREEN_COLOR}---------->> docker-compose 安装成功!${RES}"
fi


test ! -e "./.env" && wget -N $BASH_CONFIG/.env
test ! -e "./docker-compose.yml" && wget -N $BASH_CONFIG/docker-compose.yml



#创建docker目录
if [ ! -d "$DOCKER_DIR" ]; then
	echo '创建目录.'$DOCKER_DIR
    mkdir -p $DOCKER_DIR
fi


if [ ! -d "${DOCKER_DIR}/nacos/" ]; then
# 创建 nacos 目录
echo -e "${GREEN_COLOR}---> create [nacos] directory start.${RES}"
mkdir -p ${DOCKER_DIR}/nacos/master/init.d ${DOCKER_DIR}/nacos/master/logs \
		${DOCKER_DIR}/nacos/slave1/init.d ${DOCKER_DIR}/nacos/slave1/logs \
		${DOCKER_DIR}/nacos/slave2/init.d ${DOCKER_DIR}/nacos/slave2/logs
fi

# 创建 sentinel 目录
#echo -e "${GREEN_COLOR}---> create [sentinel] directory start.${RES}"
#if [ ! -d "${DOCKER_DIR}/sentinel/" ]; then
#mkdir -p ${DOCKER_DIR}/sentinel/conf ${DOCKER_DIR}/sentinel/data ${DOCKER_DIR}/sentinel/logs
#fi

if [ ! -d "${DOCKER_DIR}/minio/" ]; then
# 创建 nginx 目录
echo -e "${GREEN_COLOR}---> create [minio] directory start.${RES}"
mkdir -p ${DOCKER_DIR}/minio/data ${DOCKER_DIR}/minio/config
fi

if [ ! -d "${DOCKER_DIR}/nginx/" ]; then
# 创建 nginx 目录
echo -e "${GREEN_COLOR}---> create [nginx] directory start.${RES}"
mkdir -p ${DOCKER_DIR}/nginx/api/conf ${DOCKER_DIR}/nginx/api/logs ${DOCKER_DIR}/nginx/api/html \
		${DOCKER_DIR}/nginx/web/conf ${DOCKER_DIR}/nginx/web/logs ${DOCKER_DIR}/nginx/web/html
fi


if [ ! -d "${DOCKER_DIR}/redis/" ]; then
# 创建 redis 目录
echo -e "${GREEN_COLOR}---> create [redis] directory start.${RES}"
mkdir -p ${DOCKER_DIR}/redis/conf ${DOCKER_DIR}/redis/data
fi


if [ ! -d "${DOCKER_DIR}/rabbitmq/" ]; then
# 创建 rabbitmq 目录
echo -e "${GREEN_COLOR}---> create [rabbitmq] directory start.${RES}"
mkdir -p ${DOCKER_DIR}/rabbitmq/data
fi


if [ ! -d "${DOCKER_DIR}/elasticsearch/" ]; then
# 创建 elasticsearch 目录
echo -e "${GREEN_COLOR}---> create [elasticsearch] directory start.${RES}"
mkdir -p ${DOCKER_DIR}/elasticsearch/master/conf ${DOCKER_DIR}/elasticsearch/master/data ${DOCKER_DIR}/elasticsearch/master/logs \
    ${DOCKER_DIR}/elasticsearch/slave1/conf ${DOCKER_DIR}/elasticsearch/slave1/data ${DOCKER_DIR}/elasticsearch/slave1/logs \
    ${DOCKER_DIR}/elasticsearch/slave2/conf ${DOCKER_DIR}/elasticsearch/slave2/data ${DOCKER_DIR}/elasticsearch/slave2/logs
fi


if [ ! -d "${DOCKER_DIR}/kibana/" ]; then
# 创建 kibana 目录
echo -e "${GREEN_COLOR}---> create [kibana] directory start.${RES}"
mkdir -p ${DOCKER_DIR}/kibana/conf ${DOCKER_DIR}/kibana/logs
fi


if [ ! -d "${DOCKER_DIR}/logstash/" ]; then
# 创建 logstash 目录
echo -e "${GREEN_COLOR}---> create [logstash] directory start.${RES}"
mkdir -p ${DOCKER_DIR}/logstash/conf ${DOCKER_DIR}/logstash/logs
fi


if [ ! -d "${DOCKER_DIR}/filebeat/" ]; then
# 创建 filebeat 目录
echo -e "${GREEN_COLOR}---> create [filebeat] directory start.${RES}"
mkdir -p ${DOCKER_DIR}/filebeat/conf ${DOCKER_DIR}/filebeat/logs ${DOCKER_DIR}/filebeat/data
fi

#echo -e "${GREEN_COLOR}===> create directory success.${RES}"


# 目录授权(data/logs 都要授读/写权限)
#echo -e "${VIOLET_COLOR}---> directory authorize start.${RES}"

if [ -d "${DOCKER_DIR}/nginx/" ]; then
chmod 777 ${DOCKER_DIR}/nginx/web/logs/ ${DOCKER_DIR}/nginx/api/logs/
fi

if [ -d "${DOCKER_DIR}/nacos/" ]; then
chmod 777 ${DOCKER_DIR}/nacos/master/logs/ ${DOCKER_DIR}/nacos/slave1/logs/ ${DOCKER_DIR}/nacos/slave2/logs/
fi

if [ -d "${DOCKER_DIR}/redis/" ]; then
chmod 777 ${DOCKER_DIR}/redis/data/
fi

if [ -d "${DOCKER_DIR}/elasticsearch/" ]; then
chmod 777 ${DOCKER_DIR}/elasticsearch/master/data/ ${DOCKER_DIR}/elasticsearch/master/logs/ \
    ${DOCKER_DIR}/elasticsearch/slave1/data/ ${DOCKER_DIR}/elasticsearch/slave1/logs/ \
    ${DOCKER_DIR}/elasticsearch/slave2/data/ ${DOCKER_DIR}/elasticsearch/slave2/logs
fi

if [ -d "${DOCKER_DIR}/filebeat/" ]; then
chmod 777 ${DOCKER_DIR}/filebeat/data/ ${DOCKER_DIR}/filebeat/logs/
fi

#echo -e "${VIOLET_COLOR}===> directory authorize success.${RES}"


download(){
	wget -N -P $2  $1
}


# 移动配置文件
test ! -e "${DOCKER_DIR}/nacos/master/init.d/custom.properties" && download $BASH_CONFIG/nacos/init.d/custom.properties ${DOCKER_DIR}/nacos/master/init.d

test ! -e "${DOCKER_DIR}/nginx/api/conf/nginx.conf" && download $BASH_CONFIG/nginx/api/nginx.conf ${DOCKER_DIR}/nginx/api/conf
test ! -e "${DOCKER_DIR}/nginx/web/conf/nginx.conf" && download $BASH_CONFIG/nginx/web/nginx.conf ${DOCKER_DIR}/nginx/web/conf
test ! -e "${DOCKER_DIR}/nginx/web/html/index.html" && download $BASH_CONFIG/nginx/web/html/index.html ${DOCKER_DIR}/nginx/web/html

test ! -e "${DOCKER_DIR}/redis/conf/redis.conf" && download $BASH_CONFIG/redis.conf ${DOCKER_DIR}/redis/conf


test ! -e "${DOCKER_DIR}/elasticsearch/master/conf/es-master.yml" && download $BASH_CONFIG/es-master.yml ${DOCKER_DIR}/elasticsearch/master/conf
test ! -e "${DOCKER_DIR}/elasticsearch/slave1/conf/es-slave1.yml" && download $BASH_CONFIG/es-slave1.yml ${DOCKER_DIR}/elasticsearch/slave1/conf
test ! -e "${DOCKER_DIR}/elasticsearch/slave2/conf/es-slave2.yml" && download $BASH_CONFIG/es-slave2.yml ${DOCKER_DIR}/elasticsearch/slave2/conf


test ! -e "${DOCKER_DIR}/kibana/conf/kibana.yml" && download  $BASH_CONFIG/kibana.yml ${DOCKER_DIR}/kibana/conf

test ! -e "${DOCKER_DIR}/logstash/conf/logstash-filebeat.conf" && download  $BASH_CONFIG/logstash-filebeat.conf ${DOCKER_DIR}/logstash/conf
test ! -e "${DOCKER_DIR}/logstash/conf/logstash.yml" && download  $BASH_CONFIG/logstash.yml ${DOCKER_DIR}/logstash/conf

test ! -e "${DOCKER_DIR}/filebeat/conf/filebeat.yml" && download  $BASH_CONFIG/filebeat.yml ${DOCKER_DIR}/filebeat/conf



echo -e "${RED_COLOR}>>>>>>>>>>>>>>>>>>>>>>>>>> Init The End   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<${RES}"


# 部署项目
echo -e "${BLUE_COLOR}=========================> Docker deploy Start <========================${RES}"
#docker-compose up --build -d

#关闭所有模块
stop(){
	docker-compose stop
}

#删除所有模块
rm(){
	docker-compose rm
}

#删除Tag为空的镜像
rmiNoneTag(){
	docker images|grep none|awk '{print $3}'|xargs docker rmi -f
}


#根据输入参数,选择执行对应方法,不输入则执行使用说明
case "$1" in
"nacos")
	docker-compose up -d --build nacos
;;
"sentinel")
	docker-compose up -d --build sentinel
;;
"api-nginx")
	docker-compose up -d --build api-nginx
;;
"web-nginx")
	docker-compose up -d --build web-nginx
;;
"redis")
	docker-compose up -d --build redis-master
;;
"rabbitmq")
	docker-compose up -d --build rabbitmq
;;
"zipkin")
	docker-compose up -d --build zipkin
;;
"minio")
	docker-compose up -d --build minio
;;
"elk")
	docker-compose up -d --build es-master es-slave1 es-slave2 es-head kibana filebeat logstash
;;
"base")
	docker-compose up -d  nacos sentinel api-nginx web-nginx redis-master rabbitmq zipkin
;;
"stop")
	stop
;;
"rm")
	rm
;;
"rmiNoneTag")
	rmiNoneTag
;;
*)
	usage
;;
esac
# end::code[]