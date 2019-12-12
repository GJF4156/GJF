<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
</head>
<body>
<h1>XXXX信息系统-登录</h1>
<hr />
<form action="User/userLogin" method="post">
	用户名：<input type="text" name="username" /><br />
	密码：<input type="password" name="password" /><br />
	
	<input type="submit" value="登录" />

</form>
<h3><font color=red>${msg }</font></h3>
</body>
</html>