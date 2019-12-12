<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
</head>
<body>
<h1>XXXX信息系统-注册</h1>
<hr />
<form action="RegistServlet" method="post">
	用户名：<input type="text" name="username" /><br />
	密码：<input type="password" name="password" /><br />
	性别：<label><input name="gender" type="radio" value="男" checked/>男</label> 
		<label><input name="gender" type="radio" value="女" />女 </label><br />
	出生日期：<input type="text" name="birthdate" value="2000-10-10"/>(格式：1990-09-09)<br />
	个人简介：<textarea name="description" cols=70 rows=8></textarea><br />
	<input type="submit" value="注册" />

</form>
<h3><font color=red>${msg }</font></h3>
</body>
</html>