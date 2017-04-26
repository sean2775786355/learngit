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
    	//这是需要计算的
		int pageCount=0;
		//这是查表查到的
		int rowCount=0;
		//pagenow是指当前显示页数
		int pageNow=1;
		//指定每页显示的记录数目
		int pageSize=4;
		//动态的接受pageNow
		
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		//解决中文乱码问题，采用gbk
		//这里有异常，采用抛出异常的方法
		response.setContentType("text/html;charset=gbk");
		
		String s_pageNow=request.getParameter("pageNow");
		if(s_pageNow==null)
		{
			//用户第一次进入
		}else{
			//用户再次进入
			pageNow=Integer.parseInt(s_pageNow);
		}
		try {
			
			
			
				//连接数据库
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				//得到连接
				ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/t2", "root", "067015");
				String sql="select count(*) from user3;";
				ps=ct.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next())
				{
				 rowCount=rs.getInt(1);
				}
				//计算pageCount
				if((rowCount%pageSize)==0)
				{
					pageCount=rowCount/pageSize;
					
				}else{
					pageCount=(rowCount/pageSize)+1;
					
				}
				
				System.out.println(pageCount);
			
			
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
			pw.println("hello world!"+u_name);
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<center>");
			pw.println("<br><img src=imgs/1.gif with=200px height=150px>");
			pw.println("<h1>恭喜你！登录成功<h1>");
			pw.println("<a href=Login>返回重新登录</a>");
			//制作一个表格
			pw.println("<table border=1>");
			//表头
			pw.println("<tr><td>id</td><td>username</td><td>passwd</td><td>age</td><picturename></tr>");
			ps=ct.prepareStatement("select * from user3 limit ?,4");
			//个？号添加值
			ps.setInt(1, (pageNow-1)*pageSize);
			rs=ps.executeQuery();
			//上一页
			
			while(rs.next())
			{
				pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
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
			//下一页
			if(pageNow<pageCount-4)
			{
				pw.println("<a href=Wel?pageNow="+(pageNow+1)+">下一页</a>");
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
	   
	   //关闭数据库资源的方法（注意关闭顺序不能颠倒）=====是连接顺序相反的
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
