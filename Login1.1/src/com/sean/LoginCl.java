package com.sean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.UserBeanCl;

public class LoginCl extends HttpServlet {
    //重写init函数
	//只会被调用一次
	public void init(){
		
		try
		{
			FileReader f=new FileReader("D:\\Count.txt");
			BufferedReader br=new BufferedReader(f);
			//读出一行数据
			String times=br.readLine();
			//一定要关闭资源
			br.close();
			//int times=Integer.parseInt(num);
			//将times放入ServletContext
			this.getServletContext().setAttribute("visitTimes", times);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//重写destroy函数
	//关闭tomcat,关机，reload被调用
	public void destroy()
	{
		try 
		{
		    
			//在新的次数写入文件
			FileWriter fw=new FileWriter("D:\\Count.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			//在文件中写入数据
			bw.write(this.getServletContext().getAttribute("visitTimes").toString());
			bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		   e.printStackTrace();
		}
	}
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	//业务逻辑
	private Connection ct=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;   
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		
		response.setContentType("text/html,charset=gbk");
		PrintWriter pw = response.getWriter();
		
		
		//=================验证用户==============================
		String u=request.getParameter("username");
		String p=request.getParameter("passwd");
		   try {
			          //调用UserBeanCl
			          UserBeanCl ubc=new UserBeanCl();
					  
					   if(ubc.CheckUser(u, p))
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
						    //将servletcontextd的visitTime所对应值++
						    String times=this.getServletContext().getAttribute("visitTimes").toString();
						    //对times++在重新放回
						    this.getServletContext().setAttribute("visitTimes", (Integer.parseInt(times)+1)+"");
						    
						    //合法用户
						    response.sendRedirect("Wel?times=times");					    
							
							
							
						   
					   }else{
						  //不合法用户
						   response.sendRedirect("Login");
					   }
		   		}  catch (Exception e) {
		   			// TODO Auto-generated catch block
		   			e.printStackTrace();
		   		}
		   
		   
	}

	
	
}
