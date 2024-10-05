---
### 👉作者QQ ：1556708905 微信：zheng0123Long (支持修改、部署调试、定制毕设)

### 👉接网站建设、小程序、H5、APP、各种系统等

### 👉选题+开题报告+任务书+程序定制+安装调试+ppt 都可以做
---

**博客地址：
[https://blog.csdn.net/2303_76227485/article/details/141716101](https://blog.csdn.net/2303_76227485/article/details/141716101)**

**视频演示：
[https://www.bilibili.com/video/BV1HzHGeHEDV/](https://www.bilibili.com/video/BV1HzHGeHEDV/)**

**毕业设计所有选题地址：
[https://github.com/zhengjianzhong0107/allProject](https://github.com/zhengjianzhong0107/allProject)**

## 基于Java+Springboot+vue3+小程序的物业管理系统小程序(源代码+数据库+万字论文+文献综述)167

## 一、系统介绍
本项目前后端分离带小程序(可以改为ssm版本)，分为用户、管理员两种角色
### 1、用户：
- 注册、登录、车位信息、通知公告、缴费提醒、维修申请、缴费、来访车辆申请、车辆出入场、个人信息、密码修改

### 3、管理员：
- 缴费统计、常住人口统计、维修信息管理、维修类型管理、缴费信息管理、缴费类型管理、车位管理、车辆出入场管理
- 访客登记管理、业主管理、缴费提醒管理、轮播图管理、公告管理

## 二、所用技术
后端技术栈：
- Springboot
- mybatisPlus
- Mysql
- Maven

前端技术栈：
- Vue3
- Vue-router
- axios
- elementPlus
- 微信小程序
- echart

## 三、环境介绍
基础环境 :IDEA/eclipse, JDK1.8, Mysql5.7及以上, Maven3.6, node14, navicat,微信开发者工具

所有项目以及源代码本人均调试运行无问题 可支持远程调试运行

## 四、页面截图
### 论文截图
![contents](./picture/picture0.png)
![contents](./picture/picture00.png)
![contents](./picture/picture000.png)
![contents](./picture/picture0000.png)
### 1、用户：
![contents](./picture/picture1.png)
![contents](./picture/picture2.png)
![contents](./picture/picture3.png)
![contents](./picture/picture4.png)
![contents](./picture/picture5.png)
![contents](./picture/picture6.png)
![contents](./picture/picture7.png)
![contents](./picture/picture8.png)
![contents](./picture/picture9.png)
![contents](./picture/picture10.png)
![contents](./picture/picture11.png)
![contents](./picture/picture12.png)
![contents](./picture/picture13.png)
![contents](./picture/picture14.png)
![contents](./picture/picture15.png)
![contents](./picture/picture16.png)
![contents](./picture/picture17.png)
### 2、管理员：
![contents](./picture/picture18.png)
![contents](./picture/picture19.png)
![contents](./picture/picture20.png)
![contents](./picture/picture21.png)
![contents](./picture/picture22.png)
![contents](./picture/picture23.png)
![contents](./picture/picture24.png)
![contents](./picture/picture25.png)
![contents](./picture/picture26.png)
![contents](./picture/picture27.png)
![contents](./picture/picture28.png)
![contents](./picture/picture29.png)
![contents](./picture/picture30.png)
![contents](./picture/picture31.png)
![contents](./picture/picture32.png)
![contents](./picture/picture33.png)
![contents](./picture/picture34.png)
![contents](./picture/picture35.png)
![contents](./picture/picture36.png)
![contents](./picture/picture37.png)
## 五、浏览地址

用户账号密码：业主账号1/123456

后台地址：http://localhost:8081

管理员账户密码：admin/admin

## 六、部署教程
1. 使用Navicat或者其它工具，在mysql中创建对应名称的数据库，并执行项目的sql文件

2. 使用IDEA/Eclipse导入server_code项目，若为maven项目请选择maven，等待依赖下载完成

3. 修改application.yml里面的数据库配置,src/main/java/com/SpringbootSchemaApplication.java启动后端项目

4. vscode或idea打开manage_code后台项目

5. 在编译器中打开terminal，执行npm install 依赖下载完成后执行 npm run serve,执行成功后会显示访问地址

6. 微信小程序打开wechat_code项目，编译好之后就运行成功了

