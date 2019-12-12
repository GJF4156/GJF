<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
</head>
<body>
	<h1>登录</h1>
	<hr color=red />

	<form action="LoginServlet" method="post">
		用户名：<input type="text" size=20 name="username" /><br /> 密码：<input
			type="password" name="password" /><br /> <input type="submit"
			value="登录" /><br /> <br />
		

	</form>
</body>
</html>