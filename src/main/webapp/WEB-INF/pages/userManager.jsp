<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
	<script type="text/javascript" src="${APP_PATH}/static/jquery-3.1.1.min.js"></script>
</head>
<body>

	<table border="1">
		<tbody>
			<tr>
				<th>姓名</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			<c:if test="${!empty users }">
			<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.userName }</td>
				<td>${user.age }</td>
				<td>
					<%-- <a href="/demo1/user/getUser?id=${user.id}">编辑</a> --%> 
					<button id="edit" onclick="edi(this,'${user.id}')">编辑</button>
					<!-- <a href="javascript:del('${user.id}');">删除</a> -->
					<button id="del" onclick="del(this,'${user.id}')">删除</button>
				</td>
			</tr>
			</c:forEach>
			</c:if>
		</tbody>
	</table>
<script type="text/javascript">
function del(obj,id){
	var r=confirm("是否确认删除？");    
	if(r==true){
		//确定执行删除
		var d_id = id;
		$.get("/demo1/user/deleteUser?id="+d_id,function(data){
			 if(data=="ok"){
				alert("删除成功!");
				//删除成功后，刷新页面信息
				location.reload();
			}else{
				alert("删除失败！!");
			} 
		});
		return true;
	}else{
		//反之取消删除
		return false;
	}
}
function edi(obj,id){
	var d_id=id;
	window.location.href="/demo1/user/getUser?id="+d_id;
}
</script>
</body>
</html>