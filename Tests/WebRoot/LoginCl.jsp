<%@ page language="java" import="java.util.*,java.sql.*,com.sp.model.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'LoginCl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <% 
       //接受用户名和密码，完成对用户的验证
       String u=request.getParameter("username");
       String p=request.getParameter("passwd");
       //调用UserBeanCl的方法，完成对用户的验证
       
       UserBeanCl ubc=new UserBeanCl();
       if(ubc.checkUser(u, p))
       {
          response.sendRedirect("Wel.jsp");
       }else{
          response.sendRedirect("Login.jsp");  
       }
       
       //验证，先不到数据库验证，简单验证
     /*  if(u.equals("sp")&&p.equals("123"))
       {
          //合法，跳转
          //如何将loginCl.jsp得到的数据传给下一个页面
          //1.cookie   2.session
          response.sendRedirect("Wel.jsp?user="+u);
          
       }else{
          //不合法
          response.sendRedirect("Login.jsp");
       }*/
       //到数据库中验证
 
      
           %>
  </body>
</html>
