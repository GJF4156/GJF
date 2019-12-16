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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css" media="all">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/application.js"></script>
</head>
<body>
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="${pageContext.request.contextPath}/klist" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">评论</a></h1>
</header>
<div class="am-g am-intro-bd">
    <div class="am-intro-left am-u-sm-3"><img src="${pageContext.request.contextPath}/images/p.png"/></div>
    <div class="am-intro-right am-u-sm-9">
        <div class="text">
            <span style="float: left;color: black;font-size: 16px"><i>${FORUM.publishUser}</i></span>
            <span class="fr gray" style="margin-right: 2%">
                <i>共&nbsp;<span class="communityPage-comment-num cmn-theme-color">${count}</span>&nbsp;条回复</i>
            </span>
        </div>
        <p style="font-size: 16px;color: #ff832c;text-align: left">${FORUM.content}</p>
        <div class="text">
            <span class="fl">${FORUM.date}</span>
        </div>
    </div>
    <hr class="layui-bg-orange">
    <form action="${pageContext.request.contextPath}/reply/createReply?fid=${FORUM.fid}" method="post">
    <textarea id="content" class="add_input" name="content" type="text" style="padding-left: 8px" placeholder="说点什么吧..."
              cols="10"
              rows="2"></textarea>
        <input type="submit" value="回复" style="float: right;margin-right: 25px;"
               class="layui-btn layui-btn-primary layui-btn-xs"/>
    </form>
</div>
<div align="center">
    <span style="color: gray;font-size: 18px;font-weight: bolder;text-align: center;">${msg}</span>
</div>
<iframe src="${pageContext.request.contextPath}/reply/queryReply?fid=${FORUM.fid}" width="100%" height="100%"></iframe>
</body>
</html>
