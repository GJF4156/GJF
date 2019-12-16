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
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">实名认证</a></h1>
</header>
<form action="${pageContext.request.contextPath}/stucard/createStuCard" method="post" enctype="multipart/form-data">
    <div class="demo" style="background: white;margin-top: 2px">
        <span class="tip gray">姓名:</span>
        <input type="text" class="input file" name="realName" placeholder="请输入真实姓名" maxlength="18"/>
    </div>
    <div class="demo" style="background: white;margin-top: 2px">
        <span class="tip gray">学号:</span>
        <input type="number" class="input file" name="stuNumber" placeholder="请输入学号" maxlength="8"/>
    </div>
    <div class="demo" style="background: white;margin-top: 2px">
        <span class="tip gray">学生证信息页照片:</span>
        <input type="file" class="input file" name="cardImage" multiple="multiple" placeholder="请上传手持学生证照片"/>
    </div>
    <div class="demo" style="background: white;margin-top: 2px">
        <input type="submit" value="提交" style="width:100%;height:35px;margin:10px auto;background:#79bbff;color: #000000;"/>
    </div>
</form>
</body>
</html>
