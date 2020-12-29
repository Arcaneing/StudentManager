# StudentManager



一个简单的课程设计。



## 实现

应专业课老师要求，，，GUI**必须用swing来实现**

一个简单的C/S架构

C <----> Server <----> SQL

### SQL

使用mysql数据库，druid实现连接池，dbutils实现sql操作（虽然这玩意还没手写的方便0.0.0.0，但手写太麻烦了）



### Servers

监听到客户端请求后,new一个线程,扔进线程池,解析json,执行jdbc任务,将结果打包成json,传回客户端



### Client

GUI部分使用java的swing来实现。

点击button后生成一个student类,将请求封装成GET类丢给addClientTread处理:new一个线程,扔进线程池,把请求打包成json,扔给服务器.接收服务器相应数据,解析,绘制.

### JDBC

用了一个连接池,加载JDBCUtil工具类的时候,先把连接池创建了,之后每次操作sql,都从连接池拿connected.
