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
<div class="communityPage-main">
    <div class="communityPage-info">
        <img class="communityPage-img" src="${pageContext.request.contextPath}/images/boy.png">
        <div>
            <p class="communityPage-title"> 饮食健康</p>
            <p class="communityPage-num"><label>话题<span
                    class="communityPage-topic-num cmn-theme-color">${clu}</span></label>
            </p>
        </div>
    </div>
    <div class="communityPage-topic cmn-theme-color-active" id="communityPage-topic">
        <a class="active" style="margin-left: 10px">全部帖子</a>
    </div>
</div>
<div class="nokeshuo">
    <c:forEach items="${FORUMS}" var="f">
        <div class="am-g am-intro-bd">
            <a href="${pageContext.request.contextPath}/forum/queryForumByFid?fid=${f.fid}">
                <div class="am-intro-left am-u-sm-3"><img src="${pageContext.request.contextPath}/images/p.png"/></div>
                <div class="am-intro-right am-u-sm-9">
                    <div class="text">
                        <span style="float: left;color: black;font-size: 16px"><i>${f.publishUser}</i></span>
                        <span class="fr gray" style="margin-right: 2%">
                                <i><span class="communityPage-comment-num cmn-theme-color">回复</span></i>
                            </span>
                    </div>
                    <p style="font-size: 16px;color: #ff832c;text-align: left">${f.content}</p>
                    <div class="text">
                        <span class="fl">${f.date}</span>
                    </div>
                </div>
            </a>
        </div>
    </c:forEach>
    <img src="${pageContext.request.contextPath}/images/none.png"/>
    <p style="font-size: 26px;color: rgba(98,98,98,0.78)">${msg}</p>
</div>
<div class="communityPage-publish-btn cmn-theme-bgcolor" id="communityPage-publish-btn">
    <a id="down_order" href="${pageContext.request.contextPath}/posting" style="color: white">发帖</a>
</div>
<div class="h50"></div>
<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default footer " id="tab2">

</div>
</body>
</html>
