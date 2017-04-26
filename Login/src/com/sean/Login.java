//登录界面
package com.sean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //解决中文乱码问题
		response.setContentType("text/html;charset=gbk");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h1>登录界面</h1>");
		//做一个表单
		pw.println("<form action=LoginCl method=post>");
		
		pw.println("用户名:<input type=text name=username><br />");
		pw.println("密码：<input type=password name=passwd><br />");
		pw.println("<input type=checkbox name=keep value=2>两周内不再重新登录<br />");
		pw.println("<input type=submit value=login>&nbsp;&nbsp;&nbsp;&nbsp;<input type=reset value=reset><br />");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		
	}

}
