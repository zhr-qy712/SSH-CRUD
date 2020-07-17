<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h>编辑用户</h>
	<form name="userForm" action="/demo1/user/updateUser" method="post">
		<input type="hidden" name="id" value="${user.id }" />
		姓名：<input type="text" name="userName" value="${user.userName }">
		年龄：<input type="text" name="age" value="${user.age }">

		<input type="submit" value="编辑">
	</form>
	
</body>
</html>