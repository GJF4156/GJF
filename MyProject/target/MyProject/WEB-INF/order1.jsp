<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css" media="all">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/application.js"></script>
    <script type="text/javascript">
        function pay() {
            alert('模拟付款');
        }
        function lianxi() {
            alert('模拟联系跑腿员');
        }
    </script>
</head>
<body>
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="${pageContext.request.contextPath}/member" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title">返费<a href="#title-link" class="" style="color: #333;">我的发布</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="#right-link" class=""> </a>
    </div>
</header>
<div class="layui-tab layui-tab-card">
    <ul class="layui-nav layui-bg-cyan">
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/mOrder/queryOrder?id=0">待接单</a></li>
        <li class="layui-nav-item "><a href="${pageContext.request.contextPath}/mOrder/queryOrder?id=2">进行中</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/mOrder/queryOrder?id=1">已完成</a></li>
    </ul>

    <div style="width: 100%;height: 100%">
        <span style="font-size: 25px;margin: 15px;">${msg}</span>
        <c:forEach items="${ORDERS}" var="o">
            <div class="c-comment">
                <span class="c-comment-num">订单编号：${o.oid}</span>
                <span class="c-comment-suc">${o.order_state}</span>
            </div>
            <div class="c-comment-list" style="border: 0;">
                <a class="o-con" href="">
                    <div class="o-con-img"><img src="${pageContext.request.contextPath}/images/boy.png"></div>
                    <div class="o-con-txt">
                        <p>${o.colId}</p>
                        <p style="color: gray;margin-top: 2px;font-size: 12px">${o.release_date}</p>
                        <span style="color: gray;margin-top: 2px;font-size: 12px">${o.address}</span>
                        <p class="price" style="font-size: 14px"> ${o.describe}</p>
                    </div>
                    <div class="o-con-much"><h4></h4></div>
                </a>
                <div class="c-com-money">
                    <span class="fr"><i>赚</i><i class="price">${o.cost}</i><i>元</i></span>
                </div>
            </div>
            <div class="c-com-btn">
                <a onclick="pay()">去付款</a>
                <a onclick="lianxi()">联系跑腿</a>
                <a href="${pageContext.request.contextPath}/mOrder/deleteMorder?oid=${o.oid}">删除订单</a>
            </div>
        </c:forEach>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/layui.all.js" charset="utf-8"></script>
<script>
    layui.use('element', function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    });
</script>
</body>
</html>
