//����model�࣬������goods����ص���
package com.sean.model;
import java.util.*;
import java.sql.*;
public class GoodsBeanBO {
		//����һЩ����
		private ResultSet rs=null;
		private Connection ct=null;
		private PreparedStatement ps=null;
		/**
		 * ����һ������ҳ
		 */
		public int getPageCount(int pageSize)
		{
			int pageCount=0;
			int rowCount=0;
			try {
				ct=new ConnDB().getConn();
				ps=ct.prepareStatement("select count(*) from admin4;");
				//�õ����ж�������¼
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
		 * ��ҳ��ʾ�������Ϣ 
		 * @param int pageSize;ÿҳ��ʾ������¼
		 * @param pageNow����ǰҳ����ʾ��ҳ��
		 * @author sean
		 * @return ArrayList ������Ҫ��ʾ�Ļ��Ｏ�ϡ�
		 * ctr+shif+m(�������)
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
	
      //=========����һ����Ʒid,�õ���Ʒ������Ϣ�ĺ���=========
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
	        	//���뵽gb
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
			//�ر���Դ
			//һ��Ҫ�ر���Դ���ǳ���Ҫ
			this.Close();
		}
		return gb;
	}

    
	//�ر����ݿ�������Դ����
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
