<%@ page language="java" import="java.util.*,java.sql.*,com.sp.model.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Wel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	   <!--
	      function abc(){
	      
	      return window.confirm("你真的要删除用户吗？");
	      
	      
	      }
	      
	   
	   
	   
	   -->
	
	</script>
     
  </head>
  
  <body bgcolor="#aaafff">
  <img alt="" src="imgs/1.png">
  <hr>
  <%
	    //防止用户非法登录
	    String u=(String)session.getAttribute("myName");
	    System.out.println(u);
  if(u==null)
  {
     //反回登录对面
     response.sendRedirect("Login.jsp?err=1");
     return;
  }
  
   %>
  <center>
   登录成功！恭喜！ <%=(String)session.getAttribute("myName") %> <br>
   
   <a href="Login.jsp">返回重新登录</a> &nbsp;&nbsp;&nbsp;<a href="Main.jsp">返回主界面</a>
   <hr>
   <h1>用户信息列表</h1>
   <%
       //定义四个分类会用的变量
       
       
       
       //调用UserBeanCl的方法(创建一个UserBeanCl的实例)，完成分页显示
      // UserBeanCl ubc=new UserBeanCl();
       
      // ArrayList al=ubc.getUserByPage(pageNow);
        
        ArrayList al=(ArrayList)request.getAttribute("result");
        
          //显示
          %>
             <table border="1">
             <tr bgcolor="pink"><td>id</td><td>username</td><td>passwd</td><td>age</td><td><a>picturename</a></td><td>修改用户</td><td>删除用户</td></tr>
         
          <%
          //定义一个颜色数组
          String [] color={"silver","pink","white"};
          for(int i=0;i<al.size();i++)
            {
               //从al中取出UserBean
               UserBean ub=(UserBean)al.get(i);
              
              
                  %>
                  <tr bgcolor="<%=color[i%3]%>"><td><%=ub.getId() %></td><td><%=ub.getUsername() %></td>
                  <td><%=ub.getPasswd() %></td><td><%=ub.getAge() %></td>
                  <td><%=ub.getPicturename() %></td><td><a href="#">修改用户</a></td><td><a onclick="return abc();" href="UserBeanServlet?flag=delUser&userId=<%=ub.getId() %>">删除用户</a></td></tr>
                  <%
     
           }
     %>
    </table>
    <%
      //首页
      out.println("<a href=UserBeanServlet?flag=fengye&pageNow=1>首页</a>");
      //得到pageCount
      String s_pageCount=(String)request.getAttribute("pageCount");
      int pageCount=Integer.parseInt(s_pageCount);
      
      //从request中取出pageNow
      int pageNow=Integer.parseInt((String)request.getAttribute("pageNow"));
      //上一页
      if(pageNow!=1)
      {
       out.println("<a href=UserBeanServlet?flag=fengye&pageNow="+(pageNow-1)+">上一页</a>");
      }
      //显示超链接
      for(int i=pageNow;i<(pageNow+5);i++)
      {
         out.println("<a href=UserBeanServlet?flag=fengye&pageNow="+i+">["+i+"]</a>");
      }
      //下一页
      if(pageNow!=pageCount)
      {
      
         out.println("<a href=UserBeanServlet?flag=fengye&pageNow="+(pageNow+1)+">下一页</a>");
      
      }
         out.println("<a href=UserBeanServlet?flag=fengye&pageNow="+pageCount+">尾页</a>");   
     %>
     
    
    
    </center>
    <hr>
  <img alt="" src="imgs/3.png">
  </body>
</html>
