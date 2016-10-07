<%@ page import="biz.CommentBiz" %>
<%@ page import="biz.CommentBizImp" %>
<%@ page import="entity.Comment" %><%--
  Created by IntelliJ IDEA.
  User: ckzippo
  Date: 10/7/16
  Time: 5:34 PM
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
            <li><a href="userPage">用户</a></li>
            <li><a href="product.html">商品</a></li>
            <li><a href="order.html">订单</a></li>
            <li class="current"><a href="commentPage">留言</a></li>
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
    您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>

<%
    // 获取评论ID
    int ecid = Integer.valueOf(request.getParameter("ecid"));

    // 根据评论ID查找评论信息
    CommentBiz commentBiz = new CommentBizImp();
    Comment comment = commentBiz.getCommentById(ecid);
    request.setAttribute("comment", comment);
%>

<div id="main" class="wrap">
    <div id="menu-mng" class="lefter">
        <div class="box">
            <dl>
                <dt>用户管理</dt>
                <dd><em><a href="user-add.jsp">新增</a></em><a href="userPage">用户管理</a></dd>
                <dt>商品信息</dt>
                <dd><em><a href="productClass-add.html">新增</a></em><a href="productClass.html">分类管理</a></dd>
                <dd><em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a></dd>
                <dt>订单管理</dt>
                <dd><a href="order.html">订单管理</a></dd>
                <dt>留言管理</dt>
                <dd><a href="commentPage">留言管理</a></dd>
                <dt>新闻管理</dt>
                <dd><em><a href="news-add.html">新增</a></em><a href="news.html">新闻管理</a></dd>
            </dl>
        </div>
    </div>
    <div class="main">
        <h2>回复留言</h2>
        <div class="manage">
            <form action="modComment">
                <table class="form">
                    <tr>
                        <td class="field">留言ID：</td>
                        <td><input type="text" class="text" name="orderId" value="${comment.ec_id}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td class="field">留言姓名：</td>
                        <td><input type="text" class="text" name="name" value="${comment.ec_nick_name}" /></td>
                    </tr>
                    <tr>
                        <td class="field" name="content">留言内容：</td>
                        <td>${comment.ec_content}</td>
                    </tr>
                    <tr>
                        <td class="field">回复内容：</td>
                        <td><textarea name="replyContent">${comment.ec_reply}</textarea></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2016 易买网 All Rights Reserved. 苏ICP证1000001号
</div>
</body>
</html>
