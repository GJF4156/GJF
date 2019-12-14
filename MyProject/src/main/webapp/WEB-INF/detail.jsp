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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css" media="all">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/application.js"></script>

</head>
<body>
<div class="am-g am-intro-bd">
    <div class="am-intro-left am-u-sm-3"><img src="${pageContext.request.contextPath}/images/p.png"/></div>
    <div class="am-intro-right am-u-sm-9">
        <div class="text">
            <span style="float: left;color: black;font-size: 16px"><i>${param.publishUser}</i></span>
            <span class="fr gray" style="margin-right: 2%">
                                <i>回复<span class="communityPage-comment-num cmn-theme-color">0</span></i>
                            </span>
        </div>
        <p style="font-size: 16px;color: #ff832c;text-align: left">${param.content}</p>
        <div class="text">
            <span class="fl">${param.date}</span>
        </div>
    </div>
    <hr class="layui-bg-orange">
    <textarea id="content" class="add_input" type="text" style="padding-left: 8px" placeholder="说点什么吧..." cols="10"
              rows="2"></textarea>
    <button type="button" style="float: right;margin-right: 25px;" class="layui-btn layui-btn-primary layui-btn-xs">回复
    </button>
</div>
</body>
</html>
