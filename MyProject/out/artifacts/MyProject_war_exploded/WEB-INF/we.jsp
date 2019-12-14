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
        <a href="${pageContext.request.contextPath}/member" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">关于我们</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="#right-link" class=""> </a>
    </div>
</header>

<div data-am-widget="slider" class="am-slider am-slider-default" data-am-slider='{}'>
    <ul class="am-slides">
        <li><img src="${pageContext.request.contextPath}/images/banner2.jpg"></li>
        <li><img src="${pageContext.request.contextPath}/images/banner4.jpg"></li>
    </ul>
</div>
<div class="am-tabs qiehuan" data-am-tabs>
    <ul class="am-tabs-nav am-nav am-nav-tabs">
        <li class="am-active"><a href="#tab1s">跑腿介绍</a></li>
        <li><a href="#tab1sa">建议留言</a></li>
    </ul>
    <div class="am-tabs-bd">
        <div class="am-tab-panel am-fade am-in am-active" id="tab1s">
            跑腿作为一种行业被人认知，并非是偶然因素。可以说，从人类有了社会分工开始，就有了跑腿的存在，只是一直没有被专业化。商品经济社会发展的趋势是竞争日益激烈，引起的是时间观念的不断增强，各行各业不断地被细分化、专业化，而人的需求却是五花八门的，这无疑会影响生活质量和工作效率。长此以往，人要正常地、舒适地生活，必然需要另一种专业的行业来弥补此不足。故而，在当今社会发展的势头上，跑腿行业以一种专业化的姿态出现，是应时顺人的。
            <iframe src="${pageContext.request.contextPath}/map" width="100%" height="100%"></iframe>
        </div>

        <div class="am-tab-panel am-fade" id="tab1sa">
            <form action="${pageContext.request.contextPath}/messiges/createMessige">
                <input type="hidden" name="mid" value="0" />
                <input type="text" name="username" placeholder="姓名" class="tab-input"/>
                <input type="text" name="phone" placeholder="电话" class="tab-input"/>
                <textarea placeholder="建议" name="suggest" class="tab-input"></textarea>
                <input type="submit" class="tab-btn"/>
            </form>
        </div>
    </div>
    <span style="text-align: center;width: 100%;font-size: 25px;color: red">${msg}</span>
</div>
<div class="h50"></div>

</body>
</html>
