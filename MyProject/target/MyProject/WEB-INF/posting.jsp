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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/timedropper.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/datedropper.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/application.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/timedropper.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datedropper.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/TimeObjectUtil.js"></script>
</head>
<body>
    <header data-am-widget="header" class="am-header am-header-default header">
        <div class="am-header-left am-header-nav">
            <a href="javascript:history.go(-1)" class="">
                <i class="am-header-icon am-icon-angle-left"></i>
            </a>
        </div>
        <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">发布中心</a></h1>
        <div class="am-header-right am-header-nav">
            <a href="#right-link" class=""> </a>
        </div>
    </header>
    <form action="${pageContext.request.contextPath}/forum/createForum">
        <textarea id="content" class="add_input" name="content" type="text" style="padding-left: 8px" placeholder="说点什么吧..."
                  cols="10"
                  rows="5">
        </textarea>
        <div style="width: 100%;text-align: center;margin-top: 50px">
            <input type="submit" value="立即发布" class=" className"/>
            <p style="font-size: 16px;color: rgba(252,21,28,0.78)">${msg}</p>
        </div>
    </form>
</body>
</html>
