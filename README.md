# StudentManager



一个简单的课程设计。



## 实现

应专业课老师要求，，，GUI**必须用极为反人类的swing来实现**

一个简单的C/S架构

C <----> Server <----> SQL

### SQL

使用mysql数据库，druid实现连接池，dbutils实现sql操作（虽然这玩意还没手写的方便0.0.0.0，但手写太麻烦了）



### Servers

这部分没想好，，正在想，，并发编程应该是个大问题。

实在不好手写就直接上Spring。



### Client

GUI部分使用java的swing来实现。

数据传递用json。

返回的结果解析后在swing上绘制。

或者明天自学一下js找室友写个html，直接在swing上贴WebView
