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
        <li><img src="${pageContext.request.contextPath}/images/banner4.jpg"></li>
        <li><img src="${pageContext.request.contextPath}/images/banner2.jpg"></li>
        <li><img src="${pageContext.request.contextPath}/images/banner1.jpg"></li>


    </ul>
</div>
<div class="am-tabs qiehuan" data-am-tabs>
    <ul class="am-tabs-nav am-nav am-nav-tabs">
        <li class="am-active"><a href="${pageContext.request.contextPath}/run_pool">常规单</a></li>
        ${msg}
    </ul>
</div>

    <div data-am-widget="intro" class="am-intro am-cf am-intro-default" id="shun">
        <c:forEach items="${ORDER_LIST}" var="o">
        <div class="am-g am-intro-bd">
            <a href="${pageContext.request.contextPath}/content?uid=${o.uid}&oid=${o.oid}&username=${o.username}&release_date=${o.release_date}&describe=${o.describe}&address=${o.address}&expect_time=${o.expect_time}&cost=${o.cost}">
                <input type="hidden" name="address" value="${o.address}"/>
                <input type="hidden" name="expect_time" value="${o.expect_time}"/>
                <div class="am-intro-left am-u-sm-3"><img src="${pageContext.request.contextPath}/images/boy.png"/>
                </div>
                <div class="am-intro-right am-u-sm-9">
                    <div class="text">
                        <span style="float: left;color: black;font-size: 16px"><i>${o.username}</i></span>
                        <span class="fr black" style="margin-right: 2%"><i>${o.order_state}</i></span>
                        <span class="fr green" style="margin-right: 5%">${o.colId}</span>
                        <span class="fr blue" style="margin-right: 5%;"> ${o.other_requirements}</span>
                    </div>
                    <p>${o.describe} ${msg}</p>
                    <div class="text">
                        <span class="fl">${o.release_date}</span>
                        <span class="fr"><i>赚</i><i class="price">${o.cost}</i><i>元</i></span>
                    </div>
                </div>
            </a>
        </div>
        </c:forEach>
    </div>

<div class="communityPage-publish-btn cmn-theme-bgcolor" id="communityPage-publish-btn"><a id="down_order"
                                                                                           href="${pageContext.request.contextPath}/add_order"
                                                                                           style="color: white">下单</a>
</div>

<div class="h50"></div>
<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default footer " id="tab1">

</div>


</body>
</html>
