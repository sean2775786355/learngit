package com.sean;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.io.*;

import javax.servlet.*;

public class LoginCl extends HttpServlet {
	 Connection ct=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
   public void doGet(HttpServletRequest request,HttpServletResponse response ) throws ServletException                       
   {
	   this.doPost(request, response);
   }
   public void doPost(HttpServletRequest request,HttpServletResponse response)
	   {   response.setContentType("text/html;charset=gbk");
		   String u=request.getParameter("username");
		   String p=request.getParameter("passwd");
		   //=================连接数据库==============================
		   try {
					   //加载驱动
					   Class.forName("com.mysql.jdbc.Driver");
					   //得到连接
					   ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/t2","root","067015");
					   //创建PrepareStatrement
					   String sql="select passwd from user3 where username=?";
					   
					   ps=ct.prepareStatement(sql); 
					   ps.setString(1, u);
					   
					    rs=ps.executeQuery();
					   if(rs.next())
					   {   //将用户信息存入session
						   //创建一个session
						   HttpSession hs=request.getSession(true);
						   //设置session时间30秒（默认时间是30分钟）
						   hs.setMaxInactiveInterval(30);
						   //向session添加属性
						   hs.setAttribute("name", u);
						   
						   String keep=request.getParameter("keep");
						   if(keep!=null)
						   {	   
							   //将用户名和密码保存到客户端cookie
							   Cookie name=new Cookie("myname",u);
							   Cookie passwd=new Cookie("mypasswd",p);
							   //设置时间
							   name.setMaxAge(14*24*3600);
							   passwd.setMaxAge(14*24*3600);
							   //回写到客户端
							   response.addCookie(name);
							   response.addCookie(passwd);
						   }
						  System.out.println(u);
						   //合法用户
						  response.sendRedirect("Wel");
						   
					   }else{
						  //不合法用户
						   response.sendRedirect("Login");
					   }
		   		}  catch (Exception e) {
		   			// TODO Auto-generated catch block
		   			e.printStackTrace();
		   		}finally{
		   			//关闭资源
		   			this.close();
		   		}
		   
	   
	   
	   
   }

   
   //关闭数据库资源的方法（注意关闭顺序不能颠倒）=====是连接顺序相反的
   public void close()
   {
	   try {
		if(rs!=null)
		   {
			   rs.close();
			   rs=null;
		   }
		if(ps!=null)
			{
				ps.close();
				ps=null;
			}
		if(ct!=null)
			{
				ct.close();
				ct=null;
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
