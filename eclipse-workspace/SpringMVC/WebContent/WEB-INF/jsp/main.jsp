<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>XXXX信息系统</title>
</head>
<body bgcolor="#87CEFA">
	<h1>XXXX信息系统</h1>
	<hr />
	欢迎您，${us.username } ${us.sex } ${us.birthdate }
	<br />
	<form action="../Post/report">
		<input type="submit" value="发表博客" /> <input type="hidden"
			name="username" value="${us.username}" /> 标题：<input type="text"
			name="title" /> 文章内容:<input type="text" name="context" /> ${msg}
	</form>
	<hr />
	<form action="${pageContext.request.contextPath}/User/selectAllUser">
		<input type="submit" value="查看所有用户" /> <br />
		<c:forEach items="${users}" var="u">
	${u.id} ${u.username }  ${u.sex }
	<a href="../User/DeleteUser?id=${u.id}">删除</a>
			<a
				href="../toEdit?id=${u.id}&username=${u.username}&password=${u.password}&sex=${u.sex}&birthdate=${u.birthdate}">修改</a>
			<br />
			<br />
		</c:forEach>
	</form>
	<hr />

	<form action="../Post/SelectAllPost">
		<input type="submit" value="查看所有博客" /> <br />
		<c:forEach items="${posts}" var="p">
	${p.pid} ${p.username}  ${p.title} ${p.context}
	<a href="../Post/deletePost?pid=${p.pid}">删除</a>
			<br />
		</c:forEach>
	</form>
	<hr />

</body>
</html>