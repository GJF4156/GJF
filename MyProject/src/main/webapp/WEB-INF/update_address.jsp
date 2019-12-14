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
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">修改地址</a></h1>

</header>
<form action="${pageContext.request.contextPath}/address/updateAddress?testId=${param.testId}">
    <input type="hidden" name="aid" value="${param.aid}"/>
    <input type="hidden" name="testId" value="${param.testId}"/>
    <div class="demo" style="background: white;margin-top: 2px">
        <span class="tip gray">收货人： </span><input type="text" id="consignee" name="consignee" class="input add_input1"
                                                  placeholder="请输入收货人名字"value="${param.consignee}"
                                                  maxlength="18"/>
    </div>
    <div class="demo" style="background: white;margin-top: 2px">
        <span class="tip gray">手机号： </span><input type="number" id="cphone" name="cphone" class="input add_input1"
                                                  placeholder="请输入收货人手机号" value="${param.cphone}"
                                                  maxlength="11"/>

    </div>
    <div class="demo" style="background: white;margin-top: 2px">
        <span class="tip gray">收货地址： </span><textarea id="content" name="content" class="add_input" type="text"
                                                      style="padding-left: 8px" placeholder="请输入收货地址"  cols="10"
                                                      rows="5">${param.content}</textarea>
    </div>
    <div class="demo" style="background: white;margin-top: 2px">
        <input type="submit" value="修改" style="width:100px;height:25px;margin-right:60px;background:#79bbff;color: #000000;float: right"/>
    </div>
</form>
</body>
</html>
