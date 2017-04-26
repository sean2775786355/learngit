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

		        //解决中文乱码问题，采用gbk
				//这里有异常，采用抛出异常的方法
				response.setContentType("text/html;charset=gbk");
				
				String s_pageNow=request.getParameter("pageNow");
				int pageNow=1;
				int pageSize=4;
				if(s_pageNow==null)
				{
					//用户第一次进入
				}else{
					//用户再次进入
				 pageNow=Integer.parseInt(s_pageNow);
				}
				try {
					
					PrintWriter pw=response.getWriter();
					//得到session值为object类型需要类型强转为String
					//创建session
					HttpSession hs=request.getSession(true);
					String u_name=(String)hs.getAttribute("name");
					System.out.println(u_name);
					//防止非法登录
					String name=null;
					String passwd=null;
					if(u_name==null)
					{   //从客户端得到所有cookie信息
						Cookie [] allCookies=request.getCookies();
						if(allCookies!=null){
							//从中取出cookie
							for(int i=0;i<allCookies.length;i++)
							{
								//依次取出cookie
								Cookie temp=allCookies[i];
								if(temp.getName().equals("myname"))
								{
									//得到cookie的值
								  name=temp.getValue();
									
								}else if(temp.getName().equals("mypasswd"))
								{
								  passwd=temp.getValue();
								}
							}
							if(name!=null&&passwd!=null)
							{
								//跳转到loginCl去验证
								response.sendRedirect("LoginCl?username="+name+"&passwd"+passwd+"");
								return;
							}
						}
						//返回登录界面
						response.sendRedirect("Login");
						return;
					}
					//调用UserBeanCl
					UserBeanCl ubc=new UserBeanCl();
					ArrayList al=ubc.getResultByPage(pageNow, pageSize);
					
					pw.println("hello world!"+u_name);
					pw.println("<html>");
					pw.println("<body>");
					pw.println("<center>");
					pw.println("<br><img src=imgs/1.gif with=200px height=150px>");
					pw.println("<h1>恭喜你！登录成功<h1>");
					pw.println("<a href=Login>返回重新登录</a>");
					//制作一个表格
					//====================添加网页计数功能===============
					
					
					
					pw.println("<table border=1>");
					//表头
					pw.println("<tr><td>id</td><td>username</td><td>passwd</td><td>age</td><picturename></tr>");
					
					//上一页
					
					for(int i=0;i<al.size();i++)
					{  
						UserBean ub=(UserBean)al.get(i);
						pw.println("<tr><td>"+ub.getId()+"</td><td>"+ub.getUsername()+"</td><td>"+ub.getPasswd()+"</td><td>"+ub.getAge()+"</td><td>"+ub.getPicturename()+"</td></tr>");
					}
					pw.println("</table>");
					if(pageNow!=1)
					{
						pw.println("<a href=Wel?pageNow="+(pageNow-1)+">上一页</a>");
					}
					//显示超链接
					for(int i=pageNow;i<=pageNow+4;i++)
					{
						pw.println("<a href=Wel?pageNow="+i+">"+i+"</a>");
					}
					int pageCount=ubc.getPageCount(); 
					
					//下一页
					if(pageNow<pageCount-4)
					{
						pw.println("<a href=Wel?pageNow="+(pageNow+1)+">下一页</a>");
					}
					pw.println("<br />该网页被访问了"+this.getServletContext().getAttribute("visitTimes").toString()+"次");
					pw.println("你的ip="+request.getRemoteAddr()+"<br />");
					pw.println("你的电脑host"+request.getRemoteHost()+"<br />");
					pw.println("</center>");
					pw.println("</body>");
					pw.println("</html>");
	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}
