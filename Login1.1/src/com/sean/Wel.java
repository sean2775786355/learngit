package com.sean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.UserBean;
import com.model.UserBeanCl;

public class Wel extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		        //��������������⣬����gbk
				//�������쳣�������׳��쳣�ķ���
				response.setContentType("text/html;charset=gbk");
				
				String s_pageNow=request.getParameter("pageNow");
				int pageNow=1;
				int pageSize=4;
				if(s_pageNow==null)
				{
					//�û���һ�ν���
				}else{
					//�û��ٴν���
				 pageNow=Integer.parseInt(s_pageNow);
				}
				try {
					
					PrintWriter pw=response.getWriter();
					//�õ�sessionֵΪobject������Ҫ����ǿתΪString
					//����session
					HttpSession hs=request.getSession(true);
					String u_name=(String)hs.getAttribute("name");
					System.out.println(u_name);
					//��ֹ�Ƿ���¼
					String name=null;
					String passwd=null;
					if(u_name==null)
					{   //�ӿͻ��˵õ�����cookie��Ϣ
						Cookie [] allCookies=request.getCookies();
						if(allCookies!=null){
							//����ȡ��cookie
							for(int i=0;i<allCookies.length;i++)
							{
								//����ȡ��cookie
								Cookie temp=allCookies[i];
								if(temp.getName().equals("myname"))
								{
									//�õ�cookie��ֵ
								  name=temp.getValue();
									
								}else if(temp.getName().equals("mypasswd"))
								{
								  passwd=temp.getValue();
								}
							}
							if(name!=null&&passwd!=null)
							{
								//��ת��loginClȥ��֤
								response.sendRedirect("LoginCl?username="+name+"&passwd"+passwd+"");
								return;
							}
						}
						//���ص�¼����
						response.sendRedirect("Login");
						return;
					}
					//����UserBeanCl
					UserBeanCl ubc=new UserBeanCl();
					ArrayList al=ubc.getResultByPage(pageNow, pageSize);
					
					pw.println("hello world!"+u_name);
					pw.println("<html>");
					pw.println("<body>");
					pw.println("<center>");
					pw.println("<br><img src=imgs/1.gif with=200px height=150px>");
					pw.println("<h1>��ϲ�㣡��¼�ɹ�<h1>");
					pw.println("<a href=Login>�������µ�¼</a>");
					//����һ�����
					//====================�����ҳ��������===============
					
					
					
					pw.println("<table border=1>");
					//��ͷ
					pw.println("<tr><td>id</td><td>username</td><td>passwd</td><td>age</td><picturename></tr>");
					
					//��һҳ
					
					for(int i=0;i<al.size();i++)
					{  
						UserBean ub=(UserBean)al.get(i);
						pw.println("<tr><td>"+ub.getId()+"</td><td>"+ub.getUsername()+"</td><td>"+ub.getPasswd()+"</td><td>"+ub.getAge()+"</td><td>"+ub.getPicturename()+"</td></tr>");
					}
					pw.println("</table>");
					if(pageNow!=1)
					{
						pw.println("<a href=Wel?pageNow="+(pageNow-1)+">��һҳ</a>");
					}
					//��ʾ������
					for(int i=pageNow;i<=pageNow+4;i++)
					{
						pw.println("<a href=Wel?pageNow="+i+">"+i+"</a>");
					}
					int pageCount=ubc.getPageCount(); 
					
					//��һҳ
					if(pageNow<pageCount-4)
					{
						pw.println("<a href=Wel?pageNow="+(pageNow+1)+">��һҳ</a>");
					}
					pw.println("<br />����ҳ��������"+this.getServletContext().getAttribute("visitTimes").toString()+"��");
					pw.println("���ip="+request.getRemoteAddr()+"<br />");
					pw.println("��ĵ���host"+request.getRemoteHost()+"<br />");
					pw.println("</center>");
					pw.println("</body>");
					pw.println("</html>");
	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}
