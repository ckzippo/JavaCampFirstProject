# JavaCampFirstProject项目说明
***

## 项目介绍
>  针对老师提供的静态HTML页面,构建后台数据库,为页面展示提供动态数据支持
>> 涉及到的静态页面如下:

###  前台页面
    * 注册登录页面
      注册信息需要验证，符合条件方可注册（信息见后面）；登录时输入用户名、密码登录，验证码，用户信息项目见下面后台页面
    * 热点新闻页面
      新闻列表的显示（类似当当网右上角的公告，新闻），点击某一条后，可以查看新闻详情
    * 留言簿页面
      可以录入标题、内容、时间（自动），可以查看留言列表（留言，回复，创建时间）。
    * 商品信息展示
      类似于当当网的界面，商品分类展示，单个分类中分页显示，点击某一个展示商品详情，可以加入购物车。显示以往浏览过的商品（记录用户最近浏览过的五种商品）
    * 购物车
      购物车的维护、结算下订单
      
### 后台页面
    * 用户信息管理
      录入用户的个人资料（id，名字，性别，出生日期，身份证号，email，手机，地址，密码）。
    * 商品信息管理
      包括商品类别管理和商品管理，商品要属于某个商品类别，可以对商品进行搜索，
      商品信息（id，名字，描述，价格，商品图片，库存）
    * 订单管理
      订单查询（可以根据订单号，订货人），订单维护（修改相关信息），
      订单执行（录入订单所处的阶段，比如审核通过，配货，发货，收货并确认）
    * 留言薄
      录入回复，删除某个留言和回复
    * 新闻管理
      新闻列表的增删改（id，标题，内容，录入时间）
      
## 数据库设计
    数据库采用MySQL, 所有表格编码方式为UTF-8。
    数据库名称: easybuy
    数据库语句可以才src/main/resources/sql文件夹下找到,并附带一些样例数据可以直接导入
    数据库涉及到如下几张表:
    * easybuy_user: 用户信息表
      PS:由于我先根据需求文档中的建表信息创建了数据库并写好了对应的接口,但是在注册页面中发现需要使用"姓名"这个字段。我懒得改数据库设计和对应的接口操作。
      构建语句: 
      `DROP TABLE IF EXISTS `easybuy_user`;
       CREATE TABLE `easybuy_user` (
         `eu_user_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
         `eu_user_name` varchar(50) NOT NULL,
         `eu_password` varchar(50) NOT NULL,
         `eu_sex` int(1) DEFAULT NULL,
         `eu_birthday` datetime DEFAULT NULL,
         `eu_identity_code` varchar(20) DEFAULT NULL,
         `eu_email` varchar(50) DEFAULT NULL,
         `eu_mobile` varchar(11) DEFAULT NULL,
         `eu_address` varchar(100) DEFAULT NULL,
         `eu_headimage` varchar(400) DEFAULT NULL,
         `eu_status` int(1) DEFAULT NULL COMMENT '1 普通用户 2 管理员',
         PRIMARY KEY (`eu_user_id`)
       ) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;`
    * easybuy_news: 新闻表
      构建语句:
      `DROP TABLE IF EXISTS `easybuy_news`;
       CREATE TABLE `easybuy_news` (
         `en_id` int(20) NOT NULL AUTO_INCREMENT,
         `en_title` varchar(100) DEFAULT NULL,
         `en_content` text,
         `en_create_time` datetime DEFAULT NULL,
         PRIMARY KEY (`en_id`)
       ) ENGINE=InnoDB DEFAULT CHARSET=utf8;`
    * easybuy_comment:留言表
      构建语句:
      `DROP TABLE IF EXISTS `easybuy_comment`;
       CREATE TABLE `easybuy_comment` (
         `ec_id` int(50) NOT NULL AUTO_INCREMENT,
         `ec_reply` varchar(200) DEFAULT NULL,
         `ec_content` text,
         `ec_create_time` datetime DEFAULT NULL,
         `ec_reply_time` datetime DEFAULT NULL,
         `ec_nick_name` varchar(50) DEFAULT NULL,
         PRIMARY KEY (`ec_id`)
       ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;`
    * easybuy_product: 商品信息表
      构建语句:
      `DROP TABLE IF EXISTS `easybuy_product`;
       CREATE TABLE `easybuy_product` (
         `ep_id` int(40) NOT NULL AUTO_INCREMENT,
         `ep_name` varchar(100) DEFAULT NULL,
         `ep_description` varchar(500) DEFAULT NULL,
         `ep_price` double DEFAULT NULL,
         `ep_stock` int(20) DEFAULT NULL,
         `epc_id` int(10) DEFAULT NULL,
         `epc_child_id` int(10) DEFAULT NULL,
         `ep_file_name` varchar(200) DEFAULT NULL,
         `ep_barcode` varchar(100) DEFAULT NULL,
         PRIMARY KEY (`ep_id`)
       ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;`
    * easybuy_product_category: 商品分类表
      构建语句:
      `DROP TABLE IF EXISTS `easybuy_product_category`;
       CREATE TABLE `easybuy_product_category` (
         `epc_id` int(20) NOT NULL AUTO_INCREMENT,
         `epc_name` varchar(100) NOT NULL,
         `epc_parent_id` int(20) NOT NULL,
         PRIMARY KEY (`epc_id`)
       ) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;`
    * easybuy_order: 订单表
      构建语句:
      `DROP TABLE IF EXISTS `easybuy_order`;
       CREATE TABLE `easybuy_order` (
         `eo_id` int(40) NOT NULL AUTO_INCREMENT,
         `eo_user_id` int(20) NOT NULL,
         `eo_user_name` varchar(50) NOT NULL,
         `eo_user_address` varchar(200) NOT NULL,
         `eo_create_time` datetime NOT NULL,
         `eo_cost` double NOT NULL,
         `eo_status` int(4) NOT NULL COMMENT '1 下单 2 审核通过 3 配货 4 送货中 5 收货并确认',
         `eo_type` int(4) NOT NULL COMMENT '1 货到付款 2 网上支付',
         PRIMARY KEY (`eo_id`)
       ) ENGINE=InnoDB DEFAULT CHARSET=utf8;`
    * easybuy_order_detail: 订单明细表
      构建语句:
      `DROP TABLE IF EXISTS `easybuy_order_detail`;
       CREATE TABLE `easybuy_order_detail` (
         `eod_id` int(40) NOT NULL AUTO_INCREMENT,
         `eo_id` int(40) NOT NULL,
         `ep_id` int(40) NOT NULL,
         `eod_quantity` int(40) NOT NULL,
         `eod_cost` double(20,0) NOT NULL,
         PRIMARY KEY (`eod_id`)
       ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
`
      
## 完成内容
   * 完成所有数据结构的定义。放置在entity包中
   * 完成所有数据库的定义。详见数据库结构章节
   * 完成用户增删改数据库接口的实现和管理后台涉及到用户的增删改界面的实现。
   * 完成评论增删改数据库接口的实现和管理后台涉及到评论的增删改界面的实现。
   * 完成商品信息增删改数据库接口的实现,管理后台涉及到商品信息增删改的页面尚未实现。
   * 完成商品分类信息增删改数据库接口的实现,管理后台涉及到商品信息增删改的页面尚未实现。
   * 未完成新闻功能模块
   * 未完成订单功能模块
   * 未完成前台数据展示页面

## 项目构建信息:
  * IDE: Intellij IDEA Ultimate
  * JRE: 1.8.0_76
  * Web容器: Tomcat 8.0.65
  * 项目控制工具: Maven
  * DataBase: MySQL 5.7
  * 作者: CKZippo@gmail.com

## 补充说明
   * 所有的已经完成的加载动态数据的HTML页面被修改成JSP页面。原有的HTML页面并未删除
   * TODO:每个页面的布局,可以将头部和尾部等框架封装起来。还没来得及做
   * 修改用户界面,有个姓名字段。。。开始在做数据库设计的时候没有这个字段,后来发现了,没时间改。就用的用户名字段的信息
   * 产品分类表格,默认的根目录parent_id是0,根目录id是1
   * 时间太紧迫,好多功能待进一步完善
      
    





        
