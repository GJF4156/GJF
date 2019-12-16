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
<div style="width: 100%;height: 100%;background: #fff">
    <c:forEach items="${REPLIES}" var="r">
        <a>
            <span style="margin: 5px;color: #FF5500;font-size: 14px;font-weight: bold;">
                ${r.username}&nbsp;&nbsp;${r.replyTime}
            </span>
        </a>&nbsp;&nbsp;回复:&nbsp;<br/>
        <span style="margin-left: 30px">${r.content}</span><br/>
    </c:forEach>
</div>
</body>
</html>
