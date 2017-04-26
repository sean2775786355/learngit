package com.sean.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.model.GoodsBean;
import com.sean.model.GoodsBeanBO;

public class ShowGoodsClServlet extends HttpServlet {

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
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		//得到type，判断用户是想分页，还是商品详细信息
		String type=request.getParameter("type");
		if(type.equals("showDetail"))
		{
		//得到要显示的货物的id
		String goodsId=request.getParameter("id");
		//调用GoodsBeanBO（model）(可以给你得到商品信息)
		
		GoodsBeanBO gbb=new GoodsBeanBO();
		
		GoodsBean gb=gbb.getGoodsBean(goodsId);
		
		//把gb放入request
		
		request.setAttribute("goodsINfo", gb);
		//跳转
		request.getRequestDispatcher("showDetail.jsp").forward(request, response);
		}else if(type.equals("fenye")){
			//得到pageNow
			String pageNow=request.getParameter("pageNow");
			//把pageNow放入request
			request.setAttribute("pageNow", pageNow);
		    //调回购物大厅
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
