<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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

	<link rel="stylesheet" type="text/css" href="/cssfile/head.css">


  </head>
  
 <body><table width="80%" border="1" align="center">
  <tr>
    <td height="178" align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="405" align="center"><table width="60%" height="212" border="1">
      <tr>
        <td height="31" align="center">登录用户</td>
      </tr>
      <tr>
        <td align="center"><form id="form1" name="form1" method="post" action="">
        用户名：<input type="text" name="username" /><br />
        密码：<input type="password" name="passwd" /><br />
        <input  type="submit" name="login" value="login"/>
        <input  type="submit" name="register" value="register" />
        
        </form></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="168" align="center">
    <jsp:include flush="true" page="tail.jsp"></jsp:include>
    
    </td>
  </tr>
</table>

</body>
</html>
