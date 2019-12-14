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
    <script>
        function a(){
            alert("提示信息！");
        }
    </script>
</head>
<body>
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="javascript:history.go(-1)" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title">返费<a href="#title-link" class="" style="color: #333;">我的发布</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="#right-link" class=""> </a>
    </div>
</header>
<div class="layui-tab layui-tab-card">
    <ul class="layui-tab-title">
        <li class="layui-this" onclick="a()">网站设置</li>
        <li onclick="a()">用户管理</li>
        <li onclick="a()">权限分配</li>
        <li onclick="a()">商品管理</li>
        <li onclick="a()">订单管理</li>
    </ul>
</div>
<script src="${pageContext.request.contextPath}/js/layui.all.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use('element', function() {
        var $ = layui.jquery,
            element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
    });
</script>
</body>
</html>
