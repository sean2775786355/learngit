<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#aaacff">
  <img src="imgs/1.png" />
  <center>
    <h1>��ѡ�����</h1>
    <a href="UserBeanServlet?pageNow=1&flag=fengye">�����û�</a><br>
    <a href="addUser.jsp">����û�</a><br>
    <a href=#>�����û�</a><br>
    <a href=#>ע���û�</a><br>
    </center>
    <hr>
    <img alt="" src="imgs/2.png">
  </body>
</html>
