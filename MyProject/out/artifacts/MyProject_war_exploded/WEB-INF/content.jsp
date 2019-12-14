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
        <a href="javascript:history.go(-1)" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">校园跑腿</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="#right-link" class=""> </a>
    </div>
</header>
<div class="am-g am-intro-bd" style="margin-top: 2px">
    <a href="">
        <div class="am-intro-left am-u-sm-3"><img src="${pageContext.request.contextPath}/images/p.png"/></div>
        <div class="am-intro-right am-u-sm-9">
            <div class="text">
                <input type="hidden" value="${param.uid}"/>
                <input type="hidden" value="${param.oid}"/>
                <span style="float: left;color: black;font-size: 16px"><i>${param.username}</i></span>
                <span class="fr" style="margin-right: 2%">举报</span>
                <span class="fr" style="margin-right: 6%"><i><i class="am-icon-phone"></i></i></span>

            </div>
            <span class="fl" style="font-size: 12px">发布于:${param.release_date}</span>
            <hr>
            <div data-am-widget="slider" class="am-slider am-slider-default" data-am-slider='{}'>
                <ul class="am-slides">
                    <%--<li><img src="${pageContext.request.contextPath}/images/banner1.jpg"></li>--%>
                    <%--<li><img src="${pageContext.request.contextPath}/images/banner4.jpg"></li>--%>
                </ul>
            </div>
            <p style="margin-top: 4px">${param.describe}</p>
            <p style="margin-top: 4px">标签</p>

            <i class="am-icon-map-marker"></i><span
                style="color: gray;margin-top: 2px;margin-left: 6px;font-size: 12px">${param.address}</span>
            <p style="color: gray;font-size: 12px">期望完成时间：${param.expect_time}</p>
            <hr>
            <div class="text">
                <span class="fr"><i>赏金</i><i style="color: red;font-size: 16px">${param.cost}</i><i>元</i></span>
            </div>
        </div>
    </a>
</div>
<div class="communityPage-publish-btn cmn-theme-bgcolor" id="communityPage-publish-btn">
    <a id="go_order" href="${pageContext.request.contextPath}/order/confirmOrder?oid=${param.oid}&uid=${param.uid}" style="color: white">抢单</a>
</div>
<div data-am-widget="duoshuo" class="am-duoshuo am-duoshuo-default" data-ds-short-name="amazeui">
    <div class="ds-thread"></div>
</div>

</body>
</html>
