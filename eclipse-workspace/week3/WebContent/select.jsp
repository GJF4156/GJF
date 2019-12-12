<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<bold><font color=red>${msg}</font></bold>
	<form action="ProductServlet">
		<input type="submit" value="查询所有商品" />
		<a href="insertProduct.jsp"><input type="button" value="插入商品" /></a>
		<table width="600" border="1" cellpadding="0">
			<tr>
				<th>商品名</th>
				<th>商品进价</th>
				<th>商品售价</th>
			</tr>
			<c:forEach var="U" items="${productAll}">
				<tr>
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