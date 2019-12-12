<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="selectUserById">
		请输入ID：<input type="text" size=10 name="id" /><br /> 
		<input type="submit" value="查询" /><br/>
		Id:${user.id}<br/>用户名： ${user.name} <br/>密码：${user.pwd} 
</form>
<a href="regist.jsp">【注册用户】</a><br />
<a href="update.jsp">【修改用户】</a><br />
<form action="deleteUserServlet">
		请输入ID：<input type="text" size=10 name="uid" /><br /> 
		<input type="submit" value="删除用户" /><br/>
		<bold><font color=red>${msg}</font></bold>
</form>
<form action="selectAllUserServlet">
		<input type="submit" value="查询所有用户" /><br/>
		<c:forEach var="u" items="${userlist}">
				${u.id} ${u.name} ${u.pwd}<br/>
		</c:forEach>
</form>
</body>
</html>