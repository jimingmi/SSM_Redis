<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
		<title>登陆</title>
	</head>
	<body>
		<form action="sys/login" method="post">
            <p>
                <label for="account">账号:</label><input type="text" name="account" id="account" value="${requestScope.account }">
            </p>
            <p>
                <label for="password">密码:</label><input type="password" name="password" id="password">
            </p>
            <p>
                <button>登陆</button>
            </p>
            <p>
                <span style="color: red">${requestScope.message }</span>
            </p>
		 </form>  
	</body>
</html>