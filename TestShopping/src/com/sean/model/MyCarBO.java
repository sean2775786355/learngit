//这是一个BO(model)
//用于处理与购物相关逻辑业务
package com.sean.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javassist.bytecode.Descriptor.Iterator;

import java.util.*;
public class MyCarBO {
	
	//定义一些变量
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
    //定义一个HashMap集合，用于存放书id和书数量
	HashMap hm=new HashMap();
	//1.添加货物
	public void addGoods(String goodsId,String goodsNum)
		{
			hm.put(goodsId, goodsNum);
		    	
		
		}
	//2.删除货物
	public void delGoods(String goodsId)
	{
		hm.remove(goodsId);
	}
	//3.清空货物
	public void clear()
		{
			hm.clear();
		}
	//4.修改货物的数量
	public void upGoods(String goodsId,String newNum)
		{
			//会覆盖相同goodsId
			hm.put(goodsId, newNum);
			
		}
	//5.显示购物车
	public ArrayList showMyCart()
		{   
		    //泛型
			ArrayList<GoodsBean> al=new ArrayList<GoodsBean>();
			
			try {
				//组织sql
				String sql="select * from admin4 goodsId in;";
				//使用迭代器，完成从hm中取出货物id 的要求（为了让大家明白，一个简单案例）
				 Iterator it=(Iterator) hm.keySet().iterator();
				 String sub="(";
				 while(it.hasNext())
				{
					//取出goodsId
					int s_goodsId=(int)it.next();
					String goodsId=Integer.toString(s_goodsId);
					//判断goodsId是不是最后一个
					if(it.hasNext())
					{
					sub+=goodsId+",";
					}else{
						sub+=goodsId+")";
					}
				}
				ct=new ConnDB().getConn();
				ps=ct.prepareStatement(sql);
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
	
	//关闭函数
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
