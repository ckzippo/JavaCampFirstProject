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
    数据库涉及到如下几张表:
    * easybuy_user: 用户信息表
      PS:由于我先根据需求文档中的建表信息创建了数据库并写好了对应的接口,但是在注册页面中发现需要使用"姓名"这个字段。我懒得改数据库设计和对应的接口操作。
      构建语句: 
    * easybuy_news: 新闻表
      构建语句:
    * easybuy_comment:留言表
      构建语句:
    * easybuy_product: 商品信息表
      构建语句:
    * easybuy_product_category: 商品分类表
      构建语句:
    * easybuy_order: 订单表
      构建语句:
    * easybuy_order_detail: 订单明细表
      构建语句:
      


## 项目构建信息:
>   IDE: Intellij IDEA Ultimate
>   JRE: 1.8.0_76
>   Web容器: Tomcat 8.0.65
>   项目控制工具: Maven
>   DataBase: MySQL 5.7
>   作者: CKZippo@gmail.com

## 补充说明
   * 所有的需要加载动态数据的HTML页面被修改成JSP页面。原有的HTML页面并未删除
   * 所有的操作几乎只考虑了操作成功的情况,因为老师没有给操作失败时的跳转页面。。。没空写页面,但是代码中均有标注
   * TODO:每个页面的布局,可以将头部和尾部等框架封装起来。还没来得及做
   * 修改用户界面,有个姓名字段。。。开始在做数据库设计的时候没有这个字段,后来发现了,没时间改。就用的用户名字段的信息
   * 产品分类表格,默认的根目录parent_id是0,根目录id是1
      
    





        