<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>所有商品列表</title>
</head>

<body>
	<form action="" method="post">
		<table width="600" border="1" cellpadding="0">
			<tr>
				<th>ID</th>
				<th>商品名</th>
				<th>商品进价</th>
				<th>商品售价</th>
			</tr>
			<c:forEach var="U" items="${productAll}">
				<tr>
					<td><input type="text" value="${U.pid}" name="pid"></td>
					<td><input type="text" value="${U.pname}" name="pname"></td>
					<td><input type="text" value="${U.market_price}"
						name="market_price"></td>
					<td><input type="text" value="${U.shop_price}"
						name="shop_price"></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>