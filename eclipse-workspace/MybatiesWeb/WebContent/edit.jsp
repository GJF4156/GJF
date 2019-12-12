<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改</title>
</head>
<body>
<h1>XXXX信息系统-修改 	</h1>
<hr />
<form action="UpdateServlet" method="post">
	用户名：<input type="text" name="username" value="${param.username}"/><br />
	密码：<input type="password" name="password" value="${param.password}"/><br />
	性别：<label><input name="sex" type="radio" value="男" checked/>男</label> 
		<label><input name="sex" type="radio" value="女" />女 </label><br />
	出生日期：<input type="text" name="birthdate" value="${param.birthdate}" />(格式：1990-09-09)<br />
	<input type="hidden" name="id" value="${param.id}" />
	<input type="submit" value="修改" />

</form>
<h3><font color=red>${msg }</font></h3>
</body>
</html>