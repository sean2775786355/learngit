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
		   //=================�������ݿ�==============================
		   try {
					   //��������
					   Class.forName("com.mysql.jdbc.Driver");
					   //�õ�����
					   ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/t2","root","067015");
					   //����PrepareStatrement
					   String sql="select passwd from user3 where username=?";
					   
					   ps=ct.prepareStatement(sql); 
					   ps.setString(1, u);
					   
					    rs=ps.executeQuery();
					   if(rs.next())
					   {   //���û���Ϣ����session
						   //����һ��session
						   HttpSession hs=request.getSession(true);
						   //����sessionʱ��30�루Ĭ��ʱ����30���ӣ�
						   hs.setMaxInactiveInterval(30);
						   //��session�������
						   hs.setAttribute("name", u);
						   
						   String keep=request.getParameter("keep");
						   if(keep!=null)
						   {	   
							   //���û��������뱣�浽�ͻ���cookie
							   Cookie name=new Cookie("myname",u);
							   Cookie passwd=new Cookie("mypasswd",p);
							   //����ʱ��
							   name.setMaxAge(14*24*3600);
							   passwd.setMaxAge(14*24*3600);
							   //��д���ͻ���
							   response.addCookie(name);
							   response.addCookie(passwd);
						   }
						  System.out.println(u);
						   //�Ϸ��û�
						  response.sendRedirect("Wel");
						   
					   }else{
						  //���Ϸ��û�
						   response.sendRedirect("Login");
					   }
		   		}  catch (Exception e) {
		   			// TODO Auto-generated catch block
		   			e.printStackTrace();
		   		}finally{
		   			//�ر���Դ
		   			this.close();
		   		}
		   
	   
	   
	   
   }

   
   //�ر����ݿ���Դ�ķ�����ע��ر�˳���ܵߵ���=====������˳���෴��
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
