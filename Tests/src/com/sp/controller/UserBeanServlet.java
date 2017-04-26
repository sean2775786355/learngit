//这个控制器，将处理用户的分页显示，删除，修改
package com.sp.controller;
import com.sp.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.model.*;
public class UserBeanServlet extends HttpServlet {

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
        //得到用户希望显示的PageNow
		String s_pageNow=request.getParameter("pageNow");
	   //获得标志
		String flag=request.getParameter("flag");
		//如果要分页显示用户信息
		if(flag.equals("fengye"))
		{
			try{
				
				System.out.println("分页是走的UserBeanClservlet");
				int pageNow=Integer.parseInt(s_pageNow);
				//调用UserBeanCl
				UserBeanCl ubc=new UserBeanCl();
				
				//准备好
		    	ArrayList al=ubc.getUserByPage(pageNow);
			    int pageCount=ubc.getPageCount();
			    //将al,pageNow,pagecount放入到request中
			    request.setAttribute("result",al);
			    request.setAttribute("pageCount", pageCount+"");
			    request.setAttribute("pageNow", pageNow+"");
			    //重新跳转回wel.jsp
			    request.getRequestDispatcher("Wel.jsp").forward(request, response);
			    
			 }catch(Exception e){
				e.printStackTrace();
			 }
		
		}else if(flag.equals("delUser")){
			
					try {
						//完成删除
						//1.得到删除用户的id(驼峰法，匈牙利法)
						String userId=request.getParameter("userId");
						//创建UserBeanCl
						UserBeanCl ubc=new UserBeanCl();
						
						
						if(ubc.deUserById(userId))
						{
							
							//删除成功
							
							request.getRequestDispatcher("suc.jsp").forward(request, response);
						    // response.sendRedirect("suc.jsp");
						}else{
							
							//删除失败
							request.getRequestDispatcher("err.jsp").forward(request, response);
						    //response.sendRedirect("err.jsp");
						
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		
		//=====================添加用户============================
		
		else if(flag.equals("addUser")){
			
			try {
				//完成添加功能
				//得到用户输入信息
				
				String name=request.getParameter("username");
				String passwd=request.getParameter("password");
				String age=request.getParameter("age");
				String picture=request.getParameter("picture");
				
				
				UserBeanCl ubc=new UserBeanCl();
				
				
				if(ubc.addUser(name, passwd, age, picture))
				{
					
					//添加用户成功
					
					request.getRequestDispatcher("suc.jsp").forward(request, response);
				    // response.sendRedirect("suc.jsp");
				}else{
					
					//添加用户失败
					request.getRequestDispatcher("err.jsp").forward(request, response);
				    //response.sendRedirect("err.jsp");
				
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
		
		
		
	}
       
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
