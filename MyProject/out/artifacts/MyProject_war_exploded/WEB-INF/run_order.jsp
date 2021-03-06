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
<body style="background: #f4f4f4" >
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="${pageContext.request.contextPath}/member" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title">返费<a href="#title-link" class="" style="color: #333;">我的抢单</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="#right-link" class=""> </a>
    </div>
</header>

<ul class="order-style" id="aaa">
    <%--<li class="current"><a href="${pageContext.request.contextPath}/order/queryOrderByReceipt">全部</a></li>--%>
    <li><a href="${pageContext.request.contextPath}/order/queryOrderByOrderState?order_state=2">进行中</a></li>
    <li><a href="${pageContext.request.contextPath}/order/queryOrderByOrderState?order_state=1">已完成</a></li>

</ul>
${msg}
<c:forEach items="${ORDER_LIST_BY_RECEIPT}" var="order" >

    <div style="margin-bottom: 10px;padding-bottom: 5px"  >
        <div class="c-comment" >
            <span class="c-comment-num">订单编号：${order.oid}</span>
            <span class="c-comment-suc" id="state">${order.order_state}</span>
        </div>
        <div class="c-comment-list" style="border: 0;">
            <a class="o-con" href="">
                <div class="o-con-img"><img src="${pageContext.request.contextPath}/images/boy.png"></div>
                <div class="o-con-txt">
                    <p>${order.colId}</p>
                    <p style="color: gray;margin-top: 2px;font-size: 12px">发布于:${order.release_date}</p>
                    <span style="color: gray;margin-top: 2px;font-size: 12px">${order.address}</span>
                    <p class="price" style="font-size: 14px">${order.describe}</p>
                    <p style="color: gray;margin-top: 2px;font-size: 12px">截至时间:${order.expect_time}</p>
                </div>
                <div class="o-con-much"><h4></h4></div>
            </a>
            <div class="c-com-money">
                <span class="fr"><i>赚</i><i class="price">${order.cost}</i><i>元</i></span>
            </div>
        </div>
        <div class="c-com-btn">
            <a href="#" id="linxi">联系客户</a>
            <a href="#" id="delete">取消订单</a>
        </div>
    </div>
</c:forEach>
</body>
</html>
