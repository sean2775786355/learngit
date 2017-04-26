//这是model类，处理与goods表相关的类
package com.sean.model;
import java.util.*;
import java.sql.*;
public class GoodsBeanBO {
		//定义一些变量
		private ResultSet rs=null;
		private Connection ct=null;
		private PreparedStatement ps=null;
		/**
		 * 返回一共多少页
		 */
		public int getPageCount(int pageSize)
		{
			int pageCount=0;
			int rowCount=0;
			try {
				ct=new ConnDB().getConn();
				ps=ct.prepareStatement("select count(*) from admin4;");
				//得到共有多少条记录
				rs=ps.executeQuery();
				if(rs.next())
				{
					rowCount=rs.getInt(1);
				}
				if(rowCount%pageSize==0)
				{
					pageCount=rowCount/pageSize;
				}else{
					pageCount=rowCount/pageSize+1;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				this.Close();
			}
			return pageCount;
		}
	   
		/**
		 * 分页显示货物的信息 
		 * @param int pageSize;每页显示几条记录
		 * @param pageNow；当前页面显示的页数
		 * @author sean
		 * @return ArrayList 【就是要显示的货物集合】
		 * ctr+shif+m(可引入包)
		 */
		public ArrayList getGoodsByPage(int pageSize,int pageNow)
		{
			ArrayList al=new ArrayList();
			try {
				ct=new ConnDB().getConn();
				ps=ct.prepareStatement("select * from admin4 limit ?,6;");
				ps.setInt(1, pageSize*(pageNow-1));
				rs=ps.executeQuery();
				while(rs.next())
				{
					GoodsBean gb=new GoodsBean();
					gb.setGoodsId(rs.getInt(1));
		        	gb.setGoodsName(rs.getString(2));
		        	gb.setGoodsIntro(rs.getString(3));
		        	gb.setGoodsPrice(rs.getFloat(4));
		            gb.setGoodsNum(rs.getInt(5));
		            gb.setPulisher(rs.getString(6));
		            gb.setPhoto(rs.getString(7));
		            gb.setType(rs.getString(8));
		            //一定要添加到集合al
		            al.add(gb);
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				this.Close();
			}
			return al;
		}
	
      //=========根据一个商品id,得到商品具体信息的函数=========
	public GoodsBean getGoodsBean(String id)
	{
		GoodsBean gb=new GoodsBean();
		try {
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select * from admin4 where goodsId=?");
	        ps.setString(1, id);
	        rs=ps.executeQuery();
	        if(rs.next())
	        {
	        	//放入到gb
	        	gb.setGoodsId(rs.getInt(1));
	        	gb.setGoodsName(rs.getString(2));
	        	gb.setGoodsIntro(rs.getString(3));
	        	gb.setGoodsPrice(rs.getFloat(4));
	            gb.setGoodsNum(rs.getInt(5));
	            gb.setPulisher(rs.getString(6));
	            gb.setPhoto(rs.getString(7));
	            gb.setType(rs.getString(8));
	            
	        }
		} catch (Exception e) {
			// TODO: handle exception
		   e.printStackTrace();
		}finally{
			//关闭资源
			//一定要关闭资源；非常重要
			this.Close();
		}
		return gb;
	}

    
	//关闭数据库连接资源函数
	public void Close()
	{    
		//抛异常
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
