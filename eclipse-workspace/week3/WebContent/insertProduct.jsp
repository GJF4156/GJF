<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="InsertProductServlet" method="post">
		商品名：<input type="text" size=20 name="pname" /><br /> 
		商品进价：<input type="text" name="mark_price" /><br /> 
		商品售价：<input type="text" name="shop_price" /><br />
		<input type="submit" value="插入" /><br />
		<bold><font color=red>${msg}</font></bold>
	</form>
</body>
</html>