//����һ������������Ҫ��ɶ��û������֤
//������������ ����ȥ���ҵ���߼�������Ҫ�ǵ���model�����������
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
        //�õ��û���������
		String u=request.getParameter("username");
		//���������������
		//u=new String(u.getBytes("iso-8859-1"),"gb2312");
		u=Tool.getNeuString(u);
		
		String p=request.getParameter("passwd");
		//ʹ��ģ�ͣ�UserBeanCl������ɶ��û���֤
		//1.����һ������
		System.out.println("servlet it");
		UserBeanCl ubc=new UserBeanCl();
		
		//���÷���
		if(ubc.checkUser(u, p))
		{    
			//����ת��wel.jspҳ��ʱ���Ͱ���ʾ���ݸ�wel.jsp
			//׼����
	    	ArrayList al=ubc.getUserByPage(1);
		    int pageCount=ubc.getPageCount();
		    //��al,pageNow,pagecount���뵽request��
		    request.setAttribute("result",al);
		    request.setAttribute("pageCount", pageCount+"");
		    request.setAttribute("pageNow", "1");
			//�Ϸ��û�
			//ת��
			//response.sendRedirect("Wel.jsp");
	       //���û�������session�Ա����� ;
		    
		    request.getSession().setAttribute("myName", u);
		    
			//��ΪsendRedierct����Ч�ʲ��ߣ��������������Ҫ����ת��
			request.getRequestDispatcher("Main.jsp").forward(request, response);
			//���ַ�������Ч�ʸߣ�ͬʱrequest�еĶ����������һ��ʹ��
			//response.sendRedirect("Main.jsp");
		}else{
			//���Ϸ�
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
