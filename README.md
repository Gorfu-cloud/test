### 简介

**葆康减脂网**，是一个依托食物图片智能识别技术，智能识别食物结构和成分、热量并作出科学评价的远程健康服务平台。

- 版本v2.3.1
- 创建时间：2019-07-28
- 修改时间：2019-10-24

### 软件架构
云服务器 : 
- `Nginx` 反向代理 ——> tomcat :8081 
- `Redis` 非关系型数据库
- `Ftp` 图片服务器

云数据库 :
- `Mysql` 

### 安装教程

- `idea`导入 `git` 仓库
- 自动导入`Maven`依赖

### 部署说明

- 管理系统和后台程序

都是直接将 war/dist 上传到服务器根目录, 执行 ./deployWar.sh 或 ./deployVue

**注意服务器重启后需要重新启动的软件**

- `redis`
- `nginx`
- `tomcat`
- `ftp`

### 文档API使用说明

1. 接口使用 swagger2-ui bootstrap 优化
   文档[远程访问](http://sunnyqcloud.com/fatdown/doc.html)