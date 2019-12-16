<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>校园跑腿</title>
    <meta name="description" content="校园跑腿"/>
    <meta name="keywords" content="校园跑腿"/>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/application.js"></script>

</head>

<body>
<div data-am-widget="slider" class="am-slider am-slider-default" data-am-slider='{}'>
    <ul class="am-slides">
        <li><img src="${pageContext.request.contextPath}/images/banner1.jpg"></li>
        <li><img src="${pageContext.request.contextPath}/images/banner4.jpg"></li>
        <li><img src="${pageContext.request.contextPath}/images/banner2.jpg"></li>

    </ul>
</div>
<!--	<a href="add_order.jsp" class="search">
        开启你的美食之旅...
    </a>-->
<ul class="nav">
    <li>
        <a href="${pageContext.request.contextPath}/add_order">
            <img src="${pageContext.request.contextPath}/images/icon.jpg"/>
            <p>取快递</p>
        </a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/add_order">
            <img src="${pageContext.request.contextPath}/images/icon1.jpg"/>
            <p>求带饭</p>
        </a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/add_order">
            <img src="${pageContext.request.contextPath}/images/icon2.jpg"/>
            <p>求帮忙</p>
        </a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/add_order">
            <img src="${pageContext.request.contextPath}/images/icon3.jpg"/>
            <p>求陪跑</p>
        </a>
    </li>
</ul>

<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default title">
    <h2 class="am-titlebar-title "> 最新通知 </h2>
    <%--<nav class="am-titlebar-nav">--%>
        <%--<a href="${pageContext.request.contextPath}/news" class="">more &raquo;</a>--%>
    <%--</nav>--%>
</div>
<ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-3 am-avg-lg-4 am-gallery-default product">
    <c:forEach items="${NEWS}" var="n">
        <li style="width: 100%">
            <a href="${pageContext.request.contextPath}/news_details" class="">
                <h4 style="float: left;margin-right: 10px">发布最新</h4><span class="gray" style="font-size: 12px">${NEWS_DATE}</span>
                <h5 class="gray">${n.title}</h5>
                <img class="am-gallery-item">
                <img src="${pageContext.request.contextPath}/images/banner1.jpg"/>
            </a>
        </li>
    </c:forEach>
</ul>
<div class="h50"></div>
<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default footer " id="tab">

</div>

</body>
</html>
