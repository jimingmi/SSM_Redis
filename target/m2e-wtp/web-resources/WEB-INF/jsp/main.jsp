<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//项目的发布路径，例如:  /rabc
	String path = request.getContextPath();
	/*
	全路径，形式如下: http://127.0.0.1:8001/rbac/
	request.getScheme()      ——> http 获取协议
	request.getServerName()  --> 127.0.0.1 获取服务名
	request.getServerPort()  --> 8001 获取端口号
	path                     --> /rbac 获取访问的路径 路
	*/
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title>主页面</title>
	</head>
	<body>
		<h2>登录成功！</h2>
		<h3>欢迎你&nbsp;&nbsp;${sessionScope.session_user.user_name }</h3>
		<form action="sys/search">
		  <input name="search" type="text">
		  <button>查询</button>
		</form>
		<form action="sys/exit">
		  <button>退出</button>
		</form>
	</body>
</html>