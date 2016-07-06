<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="${ctx }res/js/jquery-1.7.1.js"></script>
    
    
    <title>登录</title>
  </head>
  
  <body>
    <form action="<%=basePath%>login/signinPost" method="post" >
		<table border="1">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" /> </td>
				</tr>
				<tr>
					<td><input type="submit" value="登录" /> </td>
					<td></td>
				</tr>
		</table>
	</form>
  </body>
</html>
