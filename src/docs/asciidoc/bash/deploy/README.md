## 一、调整内存: max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144](elasticsearch用户拥有的内存权限太小，至少需要262144)

#### 1.修改配置sysctl.conf
[root@localhost ~]# vi /etc/sysctl.conf
#### 2.添加下面配置: 
vm.max_map_count=262144
#### 3.重新加载: 
[root@localhost ~]# sysctl -p
#### 4.最后重新启动elasticsearch，即可启动成功。


## 二、Docker 命令自动补全
#### 1.安装依赖工具bash-complete
[root@localhost ~]# yum install -y bash-completion

[root@localhost ~]# source /usr/share/bash-completion/completions/docker

[root@localhost ~]# source /usr/share/bash-completion/bash_completion

## 三、将本文件夹内的文件拷贝至服务器
#### 1、对sh脚本赋予执行权限

```shell
chmod +x deploy.sh native.sh docker.sh unnative.sh undocker.sh sql.sh 
```

#### 2、脚本说明



```
./deploy.sh:总的脚本。提供本地和docker两种方式安装软件
docker 方式安装，请执行 ./deploy.sh docker
native 方式安装，请执行 ./deploy.sh native
native 方式卸载，请执行 ./deploy.sh unnative
docker 方式卸载，请执行 ./deploy.sh undocker

./native.sh:本地安装软件。

如果需要安装 jdk，请执行  source ./native.sh jdk
如果需要安装 tomcat，请执行  ./native.sh tomcat
如果需要安装 mysql，请执行  ./native.sh mysql
如果需要安装 nginx，请执行  ./native.sh nginx
如果需要安装以上全部软件，请执行  ./native.sh all

./docker.sh: 使用docker方式安装软件
安装 nacos，请执行  source ./docker.sh nacos
安装 sentinel，请执行  ./docker.sh sentinel
安装 api-nginx，请执行  ./docker.sh api-nginx
安装 web-nginx，请执行  ./docker.sh web-nginx
安装 redis-master，请执行  ./docker.sh redis-master
安装 rabbitmq，请执行  ./docker.sh rabbitmq
安装 elk，请执行  ./docker.sh elk
启动基础模块，请执行  ./docker.sh base
开启端口，请执行  ./docker.sh port
关闭所有模块，请执行  ./docker.sh stop
删除所有模块，请执行  ./docker.sh rm
删除Tag为空的镜像，请执行  ./docker.sh rmiNoneTag


```



#### 2.执行 ./deploy.sh

#### 3.等待服务启动完毕即可

#### 4.卸载执行 ./undeploy.sh