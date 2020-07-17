<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<h>添加用户</h>
	<form name="userForm" action="/demo1/user/addUser">
		姓名：<input type="text" name="userName">
		年龄：<input type="text" name="age">
		
		<input type="submit" value="添加">
	</form>
</body>
</html>