<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<h1>XXXX管理系统</h1>
	<hr />
	<c:forEach items="${users}" var="u">
	${u.id} ${u.username }  ${u.sex }
		<br />
	</c:forEach>
</body>
</html>