//������������������û��ķ�ҳ��ʾ��ɾ�����޸�
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
        //�õ��û�ϣ����ʾ��PageNow
		String s_pageNow=request.getParameter("pageNow");
	   //��ñ�־
		String flag=request.getParameter("flag");
		//���Ҫ��ҳ��ʾ�û���Ϣ
		if(flag.equals("fengye"))
		{
			try{
				
				System.out.println("��ҳ���ߵ�UserBeanClservlet");
				int pageNow=Integer.parseInt(s_pageNow);
				//����UserBeanCl
				UserBeanCl ubc=new UserBeanCl();
				
				//׼����
		    	ArrayList al=ubc.getUserByPage(pageNow);
			    int pageCount=ubc.getPageCount();
			    //��al,pageNow,pagecount���뵽request��
			    request.setAttribute("result",al);
			    request.setAttribute("pageCount", pageCount+"");
			    request.setAttribute("pageNow", pageNow+"");
			    //������ת��wel.jsp
			    request.getRequestDispatcher("Wel.jsp").forward(request, response);
			    
			 }catch(Exception e){
				e.printStackTrace();
			 }
		
		}else if(flag.equals("delUser")){
			
					try {
						//���ɾ��
						//1.�õ�ɾ���û���id(�շ巨����������)
						String userId=request.getParameter("userId");
						//����UserBeanCl
						UserBeanCl ubc=new UserBeanCl();
						
						
						if(ubc.deUserById(userId))
						{
							
							//ɾ���ɹ�
							
							request.getRequestDispatcher("suc.jsp").forward(request, response);
						    // response.sendRedirect("suc.jsp");
						}else{
							
							//ɾ��ʧ��
							request.getRequestDispatcher("err.jsp").forward(request, response);
						    //response.sendRedirect("err.jsp");
						
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		
		//=====================����û�============================
		
		else if(flag.equals("addUser")){
			
			try {
				//�����ӹ���
				//�õ��û�������Ϣ
				
				String name=request.getParameter("username");
				String passwd=request.getParameter("password");
				String age=request.getParameter("age");
				String picture=request.getParameter("picture");
				
				
				UserBeanCl ubc=new UserBeanCl();
				
				
				if(ubc.addUser(name, passwd, age, picture))
				{
					
					//����û��ɹ�
					
					request.getRequestDispatcher("suc.jsp").forward(request, response);
				    // response.sendRedirect("suc.jsp");
				}else{
					
					//����û�ʧ��
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
