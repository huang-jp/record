FROM usr/lib/jvm/openjdk-1.8.0.382.b05-1.el7_9.x86_64
#切换到镜像中的指定路径，设置工作目录
WORKDIR app
#会将宿主机的target/.jar文件复制到 镜像的工作目录 /app/ 下
ADD target/.jar /app.jar
#执行java -jar 命令
CMD ["java", "-jar", "app.jar"]
