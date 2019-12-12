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
	<form action="selectAllUser">
		<input type="submit" value="查询所有商品" />
		
		<%-- <table width="600" border="1" cellpadding="0">
			<c:forEach var="U" items="${user}">
				<tr>
					<td><input type="text" value="${U.id}" name="pname"></td>
					<td><input type="text" value="${U.username}"
						name="market_price"></td>
					<td><input type="text" value="${U.password}"
						name="shop_price"></td>
				</tr>
			</c:forEach>
		</table> --%>
	</form>
	${user.id}<br/>
	${user.username}<br/>
	${user.password}<br/>
</body>
</html>