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
       //�����û��������룬��ɶ��û�����֤
       String u=request.getParameter("username");
       String p=request.getParameter("passwd");
       //����UserBeanCl�ķ�������ɶ��û�����֤
       
       UserBeanCl ubc=new UserBeanCl();
       if(ubc.checkUser(u, p))
       {
          response.sendRedirect("Wel.jsp");
       }else{
          response.sendRedirect("Login.jsp");  
       }
       
       //��֤���Ȳ������ݿ���֤������֤
     /*  if(u.equals("sp")&&p.equals("123"))
       {
          //�Ϸ�����ת
          //��ν�loginCl.jsp�õ������ݴ�����һ��ҳ��
          //1.cookie   2.session
          response.sendRedirect("Wel.jsp?user="+u);
          
       }else{
          //���Ϸ�
          response.sendRedirect("Login.jsp");
       }*/
       //�����ݿ�����֤
 
      
           %>
  </body>
</html>
