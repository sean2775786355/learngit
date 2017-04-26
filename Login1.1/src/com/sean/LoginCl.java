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
    //��дinit����
	//ֻ�ᱻ����һ��
	public void init(){
		
		try
		{
			FileReader f=new FileReader("D:\\Count.txt");
			BufferedReader br=new BufferedReader(f);
			//����һ������
			String times=br.readLine();
			//һ��Ҫ�ر���Դ
			br.close();
			//int times=Integer.parseInt(num);
			//��times����ServletContext
			this.getServletContext().setAttribute("visitTimes", times);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//��дdestroy����
	//�ر�tomcat,�ػ���reload������
	public void destroy()
	{
		try 
		{
		    
			//���µĴ���д���ļ�
			FileWriter fw=new FileWriter("D:\\Count.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			//���ļ���д������
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
	//ҵ���߼�
	private Connection ct=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;   
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		
		response.setContentType("text/html,charset=gbk");
		PrintWriter pw = response.getWriter();
		
		
		//=================��֤�û�==============================
		String u=request.getParameter("username");
		String p=request.getParameter("passwd");
		   try {
			          //����UserBeanCl
			          UserBeanCl ubc=new UserBeanCl();
					  
					   if(ubc.CheckUser(u, p))
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
						    //��servletcontextd��visitTime����Ӧֵ++
						    String times=this.getServletContext().getAttribute("visitTimes").toString();
						    //��times++�����·Ż�
						    this.getServletContext().setAttribute("visitTimes", (Integer.parseInt(times)+1)+"");
						    
						    //�Ϸ��û�
						    response.sendRedirect("Wel?times=times");					    
							
							
							
						   
					   }else{
						  //���Ϸ��û�
						   response.sendRedirect("Login");
					   }
		   		}  catch (Exception e) {
		   			// TODO Auto-generated catch block
		   			e.printStackTrace();
		   		}
		   
		   
	}

	
	
}
