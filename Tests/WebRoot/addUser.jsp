<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
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
    <h1>�������û���Ϣ</h1>
    <form action="UserBeanServlet?flag=addUser" method="post">
    <table border="1">
    
    <tr><td bgcolor="pink">�û���</td><td><input type="text" name="username"></td></tr>
    <tr><td bgcolor="silver">����</td><td><input type="password" name="password"></td></tr>
    <tr><td bgcolor="pink">����</td><td><input type="text" name="age"></td></tr>
    <tr><td bgcolor="silver">ͷ��</td><td><input type="text" name="picture"></td></tr>
    <tr><td><input type="submit" value="����û�"/></td><td><input type="reset" value="����"/>
    </td></tr>
    
    
    </table>
    
    </form>
    </center>
    <hr>
    <img alt="" src="imgs/2.png">
  </body>
</html>
  