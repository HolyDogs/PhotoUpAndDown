# PhotoUpAndDown

SSM整合项目：在线通讯录+头像生成


## Powered by：

 - SpringMVC-4.3.7
 - Spring-4.3.7
 - Mybatis-3.4.5
 - MySQL-8.0
 - AJAX
 - JavaScript
 - css
 - Jquery

 - HTML5

----

## 介绍

项目使用maven管理，其中异常和非法身份由全局异常处理器和拦截器捕获并处理。使用图片上传插件，用户可以很方便地上传更换自己的头像。图片以base64编码转换为string类型保存在数据库里。用户登陆后，会读取头像和相关信息并显示在主界面上。通过一对多关系的映射，查找该用户对应的联系人列表，以表格形式打印在主界面上，用户能随时对联系人进行操作。另外，纯粹是自己的兴趣，我以联系人的id为种子（seed）为每个联系人随机生成一张图片（像github刚注册时的那种）。

----

## 展示

**用户头像上传插件：**
![](http://ww1.sinaimg.cn/large/006azB5Sly1fwkz8ltznej30fs06ejrh.jpg)
![](http://ww1.sinaimg.cn/large/006azB5Sly1fwkz9o1cvfj30e10aidgl.jpg)

>插件地址:[CLICK](http://www.jq22.com/jquery-info1845)
----

**登陆**
![](http://ww1.sinaimg.cn/large/006azB5Sly1fwkze34wjkj30z008cjrh.jpg)

---
**主界面**
![](http://ww1.sinaimg.cn/large/006azB5Sly1fwkzcwoeyaj311y0lctfu.jpg)
![](http://ww1.sinaimg.cn/large/006azB5Sly1fwkzrrro88j30vv09nq4u.jpg)

----
**随机图片**
![](http://ww1.sinaimg.cn/large/006azB5Sly1fwkztu0wp0j30xv0jomy6.jpg)
![](http://ww1.sinaimg.cn/large/006azB5Sly1fwkzuhv3mrj30s10h8myr.jpg)
随机颜色和形状....

-----
总之就是个为了熟悉ssm框架瞎写的小项目。
