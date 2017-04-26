<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--引入css文件  -->
	<link rel="stylesheet" type="text/css" href="cssfile/head.css">

  </head>
  
  <body topmargin="0" background="">
   <div align="center">
  <table width="80%" height="520" border="1">
    <tr>
      <td height="141" colspan="2" align="center">
      <!-- 引入head.jsp -->
      <jsp:include flush="true" page="head.jsp"></jsp:include>
      </td>
    </tr>
    <tr>
      <td width="25%" height="173" valign="top" align="center">
      <!-- 引入left.jsp -->
      <jsp:include flush="true" page="left.jsp"></jsp:include>
      </td>
      <td width="75%" align="center">
       <!-- 引入right.jsp -->
       <jsp:include flush="true" page="right.jsp"></jsp:include>
      </td>
    </tr>
    <tr>
      <td height="187" colspan="2" align="center">
      <jsp:include flush="true" page="tail.jsp"></jsp:include>
      </td>
    </tr>
  </table>
</div>
  </body>
</html>
