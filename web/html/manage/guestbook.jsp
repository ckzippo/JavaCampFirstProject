<%@ page import="entity.Comment" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ckzippo
  Date: 10/7/16
  Time: 3:52 PM
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
    <div class="help"><a href="../index.jsp">返回前台页面</a></div>
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
    您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>

<%
    //分页结果集
    List<Comment> commentlst = (List<Comment>) session
            .getAttribute("commentlst");

    //当前页页码
    Integer currentPageIndex = (Integer) session
            .getAttribute("currentCommentPageIndex");

    Integer lastPageIndex = (Integer) session
            .getAttribute("lastCommentPageIndex");

    Integer nextPageIndex = (Integer) session
            .getAttribute("nextCommentPageIndex");

    //总页码
    Integer totalPageIndex = (Integer) session
            .getAttribute("totalCommentPageIndex");

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
        <h2>留言管理</h2>
        <div class="manage">
            <table class="list">
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>留言内容</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                <c:if test="${not empty commentlst}">
                    <c:forEach var="comment" items="${commentlst}">
                        <tr>
                            <td class="first w4 c">${comment.ec_id}</td>
                            <td class="w1 c">${comment.ec_nick_name}</td>
                            <td>${comment.ec_content}</td>
                            <c:choose>
                                <c:when test="${not empty comment.ec_reply_time}">
                                    <td class="w1 c">已回复</td>
                                </c:when>
                                <c:when test="${empty comment.ec_reply_time}">
                                    <td class="w1 c">未回复</td>
                                </c:when>
                            </c:choose>
                            <td class="w1 c"><a href="guestbook-modify.jsp?ecid=${comment.ec_id}">修改</a> <a href="javascript:Delete(${comment.ec_id});">删除</a></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
            <table width="800px">
                <tr>
                    <td colspan="5" align="center">当前第${currentCommentPageIndex}页/总共${totalCommentPageIndex}页 &nbsp;&nbsp;

                        <c:if test="${currentCommentPageIndex>1}">
                            <a href="commentPage?pageIndex=1">首页</a> <a
                                href="commentPage?pageIndex=${lastCommentPageIndex}">上一页</a>
                        </c:if>

                        <c:if test="${currentCommentPageIndex < totalCommentPageIndex}">
                            <a href="commentPage?pageIndex=${nextCommentPageIndex}">下一页</a> <a
                                href="commentPage?pageIndex=${totalCommentPageIndex}">末页</a>
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
