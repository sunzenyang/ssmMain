<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="${ctx }res/js/jquery-1.7.1.js"></script>
    <title>用户列表</title>
    
	<script type="text/javascript">
	function del(id){
		$.get("<%=basePath%>user/delUser?id=" + id,function(data){
			if("success" == data.result){
				alert("删除成功");
				window.location.reload();
			}else{
				alert("删除失败");
			}
		});
	}
</script>
  </head>
  
  <body>
    <h6><a href="<%=basePath%>user/toAddUser">添加用户</a></h6>
	<table border="1">
		<tbody>
			<tr>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>地址</th>
				<th>编辑</th>
			</tr>
			<c:if test="${!empty userList }">
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.name }</td>
						<td>${user.age }</td>
						<td>${user.sex }</td>
						<td>${user.address }</td>
						<td>
							<a href="<%=basePath%>user/getUser?id=${user.id}">编辑</a>
							<a href="javascript:del('${user.id }')">删除</a>
						</td>
					</tr>				
				</c:forEach>
			</c:if>
		</tbody>
	</table>
  </body>
</html>
