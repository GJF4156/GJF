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
<div class="member">
    <a href="${pageContext.request.contextPath}/toMemberLogin">
        <div class="member-pic">
            <img src="${pageContext.request.contextPath}/images/p.png"/>
        </div>
    </a>
    <div style="float: left; color: #fff;margin-left: 15px;margin-top: 50px;">
        您好！<a href="" style="color:#1E9FFF;font-size: x-large">${sessionScope.USER.username}</a>
    </div>
    <div style="float: right; color: #fff;margin-left: 15px;margin-top: 50px;">
        <a href="${pageContext.request.contextPath}/User/logout"
           style="color:#FFB800;font-size:large;margin-right:25px;">注销</a>
    </div>
</div>
<ul class="member-nav">
    <a href="${pageContext.request.contextPath}/address/selectAllAddress?testId=1">
        <li><i class="am-icon-map-marker"></i><span>收货地址</span></li>
    </a>
    <a href="${pageContext.request.contextPath}/mOrder/queryOrder?id=0">
        <li><i class="am-icon-cart-arrow-down"></i><span>我的发布</span></li>
    </a>
    <a href="${pageContext.request.contextPath}/order/queryOrderByOrderState?order_state=2">
        <li><i class="am-icon-newspaper-o"></i><span>我的抢单</span></li>
    </a>
    <a href="${pageContext.request.contextPath}/account">
        <li><i class="am-icon-credit-card"></i><span>账户管理</span></li>
    </a>
    <%--<a href="${pageContext.request.contextPath}/money">--%>
    <%--<li><i class="am-icon-cc-mastercard"></i><span>我的积分</span></li>--%>
    <%--</a>--%>
</ul>
<ul class="member-nav mt">
    <a href="${pageContext.request.contextPath}/we">
        <li><i class="am-icon-phone"></i>关于我们</li>
    </a>
</ul>
<div class="h50"></div>
<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default footer " id="tab3">
</div>
</body>
</html>
