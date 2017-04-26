//这是一个控制器，主要完成对用户身份验证
//控制器本身是 不会去完成业务逻辑，它主要是调用model，完成任务处理
package com.sp.controller;
import com.sp.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginClSerlvet extends HttpServlet {

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
        //得到用户名和密码
		String u=request.getParameter("username");
		//解决中文乱码问题
		//u=new String(u.getBytes("iso-8859-1"),"gb2312");
		u=Tool.getNeuString(u);
		
		String p=request.getParameter("passwd");
		//使用模型（UserBeanCl），完成对用户验证
		//1.创建一个对象
		System.out.println("servlet it");
		UserBeanCl ubc=new UserBeanCl();
		
		//调用方法
		if(ubc.checkUser(u, p))
		{    
			//在跳转到wel.jsp页面时，就把显示数据给wel.jsp
			//准备好
	    	ArrayList al=ubc.getUserByPage(1);
		    int pageCount=ubc.getPageCount();
		    //将al,pageNow,pagecount放入到request中
		    request.setAttribute("result",al);
		    request.setAttribute("pageCount", pageCount+"");
		    request.setAttribute("pageNow", "1");
			//合法用户
			//转向。
			//response.sendRedirect("Wel.jsp");
	       //将用户名放入session以备后用 ;
		    
		    request.getSession().setAttribute("myName", u);
		    
			//因为sendRedierct方法效率不高，所以软件开发需要常常转发
			request.getRequestDispatcher("Main.jsp").forward(request, response);
			//这种方法他的效率高，同时request中的对象可以在下一面使用
			//response.sendRedirect("Main.jsp");
		}else{
			//不合法
			//response.sendRedirect("Login.jsp");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		    //response.sendRedirect("Login.jsp");
		
		}
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
