# 通用数据查询接口文档

## 需求概述

1. 设计一个通用的数据库查询 Graph UI，支持一些常规的复合条件查询


## 功能拆分

- 前端
    1. 基于Vue+ElementUI的开发环境搭建
    2. 设计数据查询的界面，支持通用连接信息配置、常规的复合条件配置、动态的数据展示
    3. 初版where条件支持 '=' '!=' '>' '>=' '<' '<=' 'in'
- 后端
    1. 基于Java+Spring的开发环境搭建
    2. 设计用于通用数据查询的三个接口（数据库连接、获取指定表的列信息、根据复合条件查询对应数据列表信息）


## 体验地址

[http://baota.yelizi.top/](http://baota.yelizi.top/)

- 体验数据库配置信息
    - host: 172.17.0.1
    - port: 3306
    - database: xyz_test
    - user: guest
    - password: guest


## 功能使用手册

1. 先输入要连接的数据库信息进行 'Connect' ，连接成功后会将所连数据库的表信息列表映射到数据表选择并可进行 'Query' 操作

![](http://img.yelizi.top/8c74bb5e-ba14-4df1-852b-5c7dce9971a5.jpg$xyz)

2. 选择想要访问的数据表，进行 'Query' 操作，默认则按自然顺序排列

![](http://img.yelizi.top/8d00cb3d-09ed-4817-9b19-95ddec994600.jpg$xyz)

3. 支持的复合条件配置，'Filter' 进行where条件选择，'Sort' 进行排序条件选择

![](http://img.yelizi.top/0abd89f0-b59c-4d38-b404-a5229c0fd88b.jpg$xyz)