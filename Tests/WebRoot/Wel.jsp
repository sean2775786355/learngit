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
	      
	      return window.confirm("�����Ҫɾ���û���");
	      
	      
	      }
	      
	   
	   
	   
	   -->
	
	</script>
     
  </head>
  
  <body bgcolor="#aaafff">
  <img alt="" src="imgs/1.png">
  <hr>
  <%
	    //��ֹ�û��Ƿ���¼
	    String u=(String)session.getAttribute("myName");
	    System.out.println(u);
  if(u==null)
  {
     //���ص�¼����
     response.sendRedirect("Login.jsp?err=1");
     return;
  }
  
   %>
  <center>
   ��¼�ɹ�����ϲ�� <%=(String)session.getAttribute("myName") %> <br>
   
   <a href="Login.jsp">�������µ�¼</a> &nbsp;&nbsp;&nbsp;<a href="Main.jsp">����������</a>
   <hr>
   <h1>�û���Ϣ�б�</h1>
   <%
       //�����ĸ�������õı���
       
       
       
       //����UserBeanCl�ķ���(����һ��UserBeanCl��ʵ��)����ɷ�ҳ��ʾ
      // UserBeanCl ubc=new UserBeanCl();
       
      // ArrayList al=ubc.getUserByPage(pageNow);
        
        ArrayList al=(ArrayList)request.getAttribute("result");
        
          //��ʾ
          %>
             <table border="1">
             <tr bgcolor="pink"><td>id</td><td>username</td><td>passwd</td><td>age</td><td><a>picturename</a></td><td>�޸��û�</td><td>ɾ���û�</td></tr>
         
          <%
          //����һ����ɫ����
          String [] color={"silver","pink","white"};
          for(int i=0;i<al.size();i++)
            {
               //��al��ȡ��UserBean
               UserBean ub=(UserBean)al.get(i);
              
              
                  %>
                  <tr bgcolor="<%=color[i%3]%>"><td><%=ub.getId() %></td><td><%=ub.getUsername() %></td>
                  <td><%=ub.getPasswd() %></td><td><%=ub.getAge() %></td>
                  <td><%=ub.getPicturename() %></td><td><a href="#">�޸��û�</a></td><td><a onclick="return abc();" href="UserBeanServlet?flag=delUser&userId=<%=ub.getId() %>">ɾ���û�</a></td></tr>
                  <%
     
           }
     %>
    </table>
    <%
      //��ҳ
      out.println("<a href=UserBeanServlet?flag=fengye&pageNow=1>��ҳ</a>");
      //�õ�pageCount
      String s_pageCount=(String)request.getAttribute("pageCount");
      int pageCount=Integer.parseInt(s_pageCount);
      
      //��request��ȡ��pageNow
      int pageNow=Integer.parseInt((String)request.getAttribute("pageNow"));
      //��һҳ
      if(pageNow!=1)
      {
       out.println("<a href=UserBeanServlet?flag=fengye&pageNow="+(pageNow-1)+">��һҳ</a>");
      }
      //��ʾ������
      for(int i=pageNow;i<(pageNow+5);i++)
      {
         out.println("<a href=UserBeanServlet?flag=fengye&pageNow="+i+">["+i+"]</a>");
      }
      //��һҳ
      if(pageNow!=pageCount)
      {
      
         out.println("<a href=UserBeanServlet?flag=fengye&pageNow="+(pageNow+1)+">��һҳ</a>");
      
      }
         out.println("<a href=UserBeanServlet?flag=fengye&pageNow="+pageCount+">βҳ</a>");   
     %>
     
    
    
    </center>
    <hr>
  <img alt="" src="imgs/3.png">
  </body>
</html>
