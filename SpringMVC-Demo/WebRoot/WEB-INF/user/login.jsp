<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>login Demo</title>
  </head>
  
  <body>
  
    <form action="${pageContext.request.contextPath}/user/loginPost" method="post">
    	<input type="text" id="username" name="username" /><br/>
    	<input type="password" id="password" name="password" /><br/>
    	<input type="submit" value="登录" />
    </form>
  </body>
</html>
