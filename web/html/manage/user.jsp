<%@ page import="entity.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ckzippo
  Date: 9/30/16
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理 - 易买网</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="../images/logo.gif" /></div>
    <div class="help"><a href="../index.html">返回前台页面</a></div>
    <div class="navbar">
        <ul class="clearfix">
            <li><a href="index.jsp">首页</a></li>
            <li class="current"><a href="user.jsp">用户</a></li>
            <li><a href="product.html">商品</a></li>
            <li><a href="order.html">订单</a></li>
            <li><a href="guestbook.html">留言</a></li>
            <li><a href="news.html">新闻</a></li>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class="welcome wrap">
        管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
    </div>
</div>
<div id="position" class="wrap">
    您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>

<%
    //分页结果集
    List<User> userlst = (List<User>) session
            .getAttribute("userlst");
    //当前页页码
    Integer currentPageIndex = (Integer) session
            .getAttribute("currentPageIndex");

    Integer lastPageIndex = (Integer) session
            .getAttribute("lastPageIndex");

    Integer nextPageIndex = (Integer) session
            .getAttribute("nextPageIndex");

    //总页码
    Integer totalPageIndex = (Integer) session
            .getAttribute("totalPageIndex");
%>
<div id="main" class="wrap">
    <div id="menu-mng" class="lefter">
        <div class="box">
            <dl>
                <dt>用户管理</dt>
                <dd><em><a href="user-add.jsp">新增</a></em><a href="user.jsp">用户管理</a></dd>
                <dt>商品信息</dt>
                <dd><em><a href="productClass-add.html">新增</a></em><a href="productClass.html">分类管理</a></dd>
                <dd><em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a></dd>
                <dt>订单管理</dt>
                <dd><a href="order.html">订单管理</a></dd>
                <dt>留言管理</dt>
                <dd><a href="guestbook.html">留言管理</a></dd>
                <dt>新闻管理</dt>
                <dd><em><a href="news-add.html">新增</a></em><a href="news.html">新闻管理</a></dd>
            </dl>
        </div>
    </div>
    <div class="main">
        <h2>用户管理</h2>
        <div class="manage">
            <table class="list">
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>Email</th>
                    <th>手机</th>
                    <th>操作</th>
                </tr>
                <c:if test="${not empty userlst}">
                <c:forEach var="user" items="${userlst}">
                    <tr>
                        <td class="first w4 c">${user.eu_user_id}</td>
                        <td class="w1 c">${user.eu_user_name}</td>
                        <td class="w2 c">${user.eu_sex}</td>
                        <td>${user.eu_email}</td>
                        <td class="w4 c">${user.eu_mobile}</td>
                        <td class="w1 c"><a href="user-modify.jsp?userid=${user.eu_user_id}">修改</a> <a href="javascript:Delete(${user.eu_user_id});">删除</a></td>
                    </tr>
                </c:forEach>
                </c:if>
            </table>
            <table width="800px">
                <tr>
                    <td colspan="5" align="center">当前第${currentPageIndex}页/总共${totalPageIndex}页 &nbsp;&nbsp;

                        <c:if test="${currentPageIndex>1}">
                        <a href="userPage?pageIndex=1">首页</a> <a
                                href="userPage?pageIndex=${lastPageIndex}">上一页</a>
                        </c:if>

                        <c:if test="${currentPageIndex < totalPageIndex}">
                        <a href="userPage?pageIndex=${nextPageIndex}">下一页</a> <a
                                href="userPage?pageIndex=${totalPageIndex}">末页</a>
                        </c:if>

                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2016 易买网 All Rights Reserved. 苏ICP证1000001号
</div>
</body>
</html>
