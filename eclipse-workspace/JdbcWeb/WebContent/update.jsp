<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
</head>
<body>
<h1>注册</h1>
<hr color=red/>
<form action="UpdateServlet">
	ID：<input type="text" size=10 name="id" value="${user.id}" /><br />
	用户名：<input type="text" name="name" value="${user.name}"/><br />
	密码：<input type="text" name="pwd" value="${user.pwd}"/><br />
	<input type="submit" value="更新" /><br />
	<bold><font color=red>${msg}</font></bold>
</form>
</body>
</html>