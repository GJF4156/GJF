<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
</head>
<body bgcolor="#FFCC00">
<h1>XXXX信息系统</h1>
<hr />
欢迎您，<a href="">${currentUser.username }</a>

${currentUser.uid }
${currentUser.gender }
${currentUser.birthdate }
<hr />
<a href="QueryServlet">[查询所有用户]</a><br/>
<c:forEach items="${users}" var="u" >
	${u.username }  ${u.gender }
	<a href="DeleteServlet?uid=${u.uid}"><img src="images/d.jpg" width=16px height=16px></a>
	<a href="edit.jsp?uid=${u.uid}&username=${u.username}&password=${u.password}&gender=${u.gender}&birthdate=${u.birthdate}"><img src="images/edit.jpg" width=16px height=16px></a> <br/>
</c:forEach>

<hr />

</body>
</html>