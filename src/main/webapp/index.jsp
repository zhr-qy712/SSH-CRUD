<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>

<script type="text/javascript">
	function addUser(){
		var form=document.form[0];
		form.action="${APP_PATH}/user/addUser";
		form.method="post";
		form.submit();
	}
	{age:"11"}
</script>
</head>
<body>
	<h>添加用户</h>
	<form name="userForm" action="">
		姓名：<input type="text" name="userName">
		年龄：<input type="text" name="age">
		
		<input type="button" value="添加" onclick="addUser()">
	</form>
</body>
</html>