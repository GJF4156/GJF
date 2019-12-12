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
<form action="RegistServlet" method="post">
	用户名：<input type="text" size=20 name="username" /><br />
	密码：<input type="password" name="password"/><br />
	性别：<input type="text" name="gender"/><br />
	出生日期：<input type="text" name="birthdate"/><br />
	简介：<textarea name="description" rows="3" cols="20" ></textarea><br />
	<input type="submit" value="注册" /><input type="button" value="重置"/><br />
	<br />
	<bold><font color=red>${msg}</font></bold>
		
</form>
</body>
</html>