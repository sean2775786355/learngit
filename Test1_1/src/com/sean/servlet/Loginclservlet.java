package com.sean.servlet;
import java.sql.*;
import com.sean.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Loginclservlet extends HttpServlet {

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    String name=request.getParameter("username");
	    String passwd=request.getParameter("passwd");
        System.out.println(name);
	    //寰楀埌杩炴帴
	    Connection ct=null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	   //鍒ゆ柇鐢ㄦ埛鏄惁鍚堟硶
	           try {
				ct=new ConnDB().getConn();
				ps=ct.prepareStatement("select passwd from user3 where username=?");
				ps.setString(1, name);
				rs=ps.executeQuery();
				if(rs.next())
				{
				
				   String p=rs.getString(1);
				   if(p.equals(passwd))
				   {
					   //璺宠浆鍒版杩庣晫闈�
                     
	
					   response.sendRedirect("Loginok.jsp");
				   }
				  
				}
				
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					//鍏抽棴璧勬簮
	             try {
	            	 if(rs!=null)
	            	 {
	            		 rs.close();
	            		 rs=null;
	            	 }else if(ps!=null)
	            	 {
	            		 ps.close();
	            		 ps=null;
	            	 }else if(ct!=null)
	            	 {
	            		 ct.close();
	            		 ct=null;
	            	 }
						
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				
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
