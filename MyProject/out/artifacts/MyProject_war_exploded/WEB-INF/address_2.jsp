<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
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
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="${pageContext.request.contextPath}/add_order" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">收货地址</a></h1>
    <%--<div class="am-header-right am-header-nav">--%>
        <%--<a href="${pageContext.request.contextPath}/add_address" class="blue" style="color: #79bbff">添加</a>--%>
    <%--</div>--%>
</header>
<a href="javascript:history.go(-1)">
    <ul class="address-list">
        <c:forEach items="${ADDRESSLIST}" var="a">
            <li class="curr">
                <a href="${pageContext.request.contextPath}/add_order?consignee=${a.consignee}&cphone=${a.cphone}&content=${a.content}">
                    <p>收货人：${a.consignee}&nbsp;&nbsp;${a.cphone}</p>
                    <p class="order-add1">收货地址：${a.content}</p>
                </a>
                <hr>
                <div class="address-cz">
                    <a style="float: right"
                       href="${pageContext.request.contextPath}/update_address?&aid=${a.aid}&consignee=${a.consignee}&cphone=${a.cphone}&content=${a.content}&testId=2">
                        <img src="${pageContext.request.contextPath}/images/bj.png"
                             style="width: 18px;">&nbsp;编辑</a>
                    <%--<a style="float: right;margin-right: 35px"--%>
                       <%--href="${pageContext.request.contextPath}/address/deleteAddress?aid=${a.aid}">删除</a>--%>
                </div>
            </li>
        </c:forEach>
    </ul>
</a>
</body>
</html>
