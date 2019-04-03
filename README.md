# Lemon
从零开始用springboot+myabtis-plus+security搭建一个后台敏捷开发框架,计划未来拓展到物联网管理平台的领域，目前只是一个脚手架。
 
  之前看到码云上还有github上很多关于前后端分离的shiro+springboot的很好的例子，发现没有springsecurity的，所以就找了一下，发现有个作者写的挺好的，作者的GitHub和码云就是下方前端源码的作者。但是那个作者的后端项目用的持久层框架是jpa，不是我擅长的mybatis,也不易于拓展，于是就萌生了自己写一套的想法。
 
  项目基于 Spring Boot 2.1.0 、 mybatis-plus3.x、 Spring Security、redis、Vue的前后端分离的权限管理系统，暂未采用分模块开发方式，还不支持分布式微服务，权限控制采用 RBAC（Role-Based Access Control，基于角色的访问控制），前端菜单支持动态路由
 
 ## 前端源码
 前端源码暂时参考eladmin-qt，地址如下项目：
 - **码云** ：https://gitee.com/elunez/eladmin-qt
 - **github** ： https://github.com/elunez/eladmin-qd
 
 ## 开发环境
 - **JDK** ：8
 - **IDE** ：IntelliJ IDEA (后端)
 - **依赖管理** ：Maven
 - **数据库** ：mysql 5.7
 
 ## 功能模块
 - 用户管理 提供用户的相关配置
 - 个人中心 提供修改头像，密码，邮箱验等功能
 - 角色管理 角色菜单分配权限
 - 权限管理 权限细化到接口
 - 菜单管理 已实现动态路由，后端可配置化
 - 系统日志 记录用户访问监控异常信息
 
 ## 技术栈
 - **基础框架** ：Spring Boot 2.1.0.RELEASE
 - **框架** ：mybatis-plus
 - **安全框架** ：Spring Security
 - **缓存框架** ：Redis
 - **日志打印** ：logback+log4jdbc
 - **接口文档** ：swagger2
 - **其他** ：fastjson,aop等
 

 ## 1月10日更新：
 调整权限框架，将shiro改为spring security,为以后上spring cloud打基础。

### 反馈交流
需要数据库sql的请联系：840013505@qq.com

