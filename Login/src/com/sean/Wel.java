package com.sean;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.*;

import javax.servlet.http.*;
public class Wel extends HttpServlet {

	     Connection ct=null;
	     PreparedStatement ps=null;
	     ResultSet rs=null;
    	//������Ҫ�����
		int pageCount=0;
		//���ǲ��鵽��
		int rowCount=0;
		//pagenow��ָ��ǰ��ʾҳ��
		int pageNow=1;
		//ָ��ÿҳ��ʾ�ļ�¼��Ŀ
		int pageSize=4;
		//��̬�Ľ���pageNow
		
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		//��������������⣬����gbk
		//�������쳣�������׳��쳣�ķ���
		response.setContentType("text/html;charset=gbk");
		
		String s_pageNow=request.getParameter("pageNow");
		if(s_pageNow==null)
		{
			//�û���һ�ν���
		}else{
			//�û��ٴν���
			pageNow=Integer.parseInt(s_pageNow);
		}
		try {
			
			
			
				//�������ݿ�
				//��������
				Class.forName("com.mysql.jdbc.Driver");
				//�õ�����
				ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/t2", "root", "067015");
				String sql="select count(*) from user3;";
				ps=ct.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next())
				{
				 rowCount=rs.getInt(1);
				}
				//����pageCount
				if((rowCount%pageSize)==0)
				{
					pageCount=rowCount/pageSize;
					
				}else{
					pageCount=(rowCount/pageSize)+1;
					
				}
				
				System.out.println(pageCount);
			
			
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
			pw.println("hello world!"+u_name);
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<center>");
			pw.println("<br><img src=imgs/1.gif with=200px height=150px>");
			pw.println("<h1>��ϲ�㣡��¼�ɹ�<h1>");
			pw.println("<a href=Login>�������µ�¼</a>");
			//����һ�����
			pw.println("<table border=1>");
			//��ͷ
			pw.println("<tr><td>id</td><td>username</td><td>passwd</td><td>age</td><picturename></tr>");
			ps=ct.prepareStatement("select * from user3 limit ?,4");
			//���������ֵ
			ps.setInt(1, (pageNow-1)*pageSize);
			rs=ps.executeQuery();
			//��һҳ
			
			while(rs.next())
			{
				pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
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
			//��һҳ
			if(pageNow<pageCount-4)
			{
				pw.println("<a href=Wel?pageNow="+(pageNow+1)+">��һҳ</a>");
			}
			pw.println("</center>");
			pw.println("</body>");
			pw.println("</html>");
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException
	{
		this.doPost(request, response);
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
