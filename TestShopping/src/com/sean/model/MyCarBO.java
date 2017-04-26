//����һ��BO(model)
//���ڴ����빺������߼�ҵ��
package com.sean.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javassist.bytecode.Descriptor.Iterator;

import java.util.*;
public class MyCarBO {
	
	//����һЩ����
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
    //����һ��HashMap���ϣ����ڴ����id��������
	HashMap hm=new HashMap();
	//1.��ӻ���
	public void addGoods(String goodsId,String goodsNum)
		{
			hm.put(goodsId, goodsNum);
		    	
		
		}
	//2.ɾ������
	public void delGoods(String goodsId)
	{
		hm.remove(goodsId);
	}
	//3.��ջ���
	public void clear()
		{
			hm.clear();
		}
	//4.�޸Ļ��������
	public void upGoods(String goodsId,String newNum)
		{
			//�Ḳ����ͬgoodsId
			hm.put(goodsId, newNum);
			
		}
	//5.��ʾ���ﳵ
	public ArrayList showMyCart()
		{   
		    //����
			ArrayList<GoodsBean> al=new ArrayList<GoodsBean>();
			
			try {
				//��֯sql
				String sql="select * from admin4 goodsId in;";
				//ʹ�õ���������ɴ�hm��ȡ������id ��Ҫ��Ϊ���ô�����ף�һ���򵥰�����
				 Iterator it=(Iterator) hm.keySet().iterator();
				 String sub="(";
				 while(it.hasNext())
				{
					//ȡ��goodsId
					int s_goodsId=(int)it.next();
					String goodsId=Integer.toString(s_goodsId);
					//�ж�goodsId�ǲ������һ��
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
		            //һ��Ҫ��ӵ�����al
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
	
	//�رպ���
	public void Close()
		{    
			//���쳣
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
