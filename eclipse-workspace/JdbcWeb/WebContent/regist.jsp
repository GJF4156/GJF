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
<form action="RegistServlet">
	ID：<input type="text" size=10 name="id" /><br />
	用户名：<input type="text" name="name"/><br />
	密码：<input type="text" name="pwd"/><br />
	<input type="submit" value="查询" /><br />
	<bold><font color=red>${msg}</font></bold>
</form>
</body>
</html>