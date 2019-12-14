<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>校园跑腿</title>
    <meta name="description" content="校园跑腿"/>
    <meta name="keywords" content="校园跑腿"/>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/amazeui.min.js"></script>
    <script type="text/javascript" src="js/application.js"></script>
</head>
<body>
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="javascript:history.go(-1)" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">实名认证</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="javascript:history.go(-1) " style="color: #79bbff">提交</a>
    </div>
</header>

    <div class="demo" style="background: white;margin-top: 2px">
        <span class="tip gray">姓名： </span><input type="text" class="input file" placeholder="请输入真实姓名"
                                                  maxlength="18"/>
    </div>
    <div class="demo" style="background: white;margin-top: 2px">
        <span class="tip gray">学生证： </span><input type="number" class="input file" placeholder="请输入学号"
                                                  maxlength="8"/>

    </div>

<div class="demo" style="background: white;margin-top: 2px">
    <span class="tip gray">学生证信息页： </span><input type="file" class="input file" placeholder="请上传手持学生证照片"
                                                maxlength="11"/>

</div>
</body>
</html>
