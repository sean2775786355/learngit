//这是一个处理类（处理User表）<----->操作UserBean
//业务逻辑部分
package com.model;
import java.sql.*;
import java.util.*;
public class UserBeanCl {
	 //业务逻辑
	 private Connection ct=null;
     private PreparedStatement ps=null;
     private ResultSet rs=null;
     private int pageCount=0;
     
    
   //=================分页功能======================
     public ArrayList getResultByPage(int pageNow,int pageSize) throws SQLException
	    {    
	    	ArrayList al=new ArrayList();
	    	try {
				
				int rowCount=0;
				
				ct=new ConnDB().getConn();
				ps=ct.prepareStatement("select count(*) from user3;");
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
				ps=ct.prepareStatement("select * from user3 limit ?,4");
				//个？号添加值
				ps.setInt(1, (pageNow-1)*pageSize);
				rs=ps.executeQuery();
				while(rs.next()){
					
					//将rs中的每条记录封装到UserBean ub
					UserBean ub=new UserBean();
					ub.setId(rs.getInt(1));
					ub.setUsername(rs.getString(2));
					ub.setPasswd(rs.getString(3));
					ub.setAge(rs.getInt(4));
					ub.setPicturename(rs.getString(5));
					//这必不可少，放入到集合中
					al.add(ub);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
	    	return al;
	     	
	    }
   //返回pageCount
     public int getPageCount()
     {
    	 return this.pageCount;
    	 
     }
	//================验证用户=======================
     public boolean CheckUser(String u,String p)
     {   
    	 boolean b=false;
    	 try {
			//得到连接
    		 ct=new ConnDB().getConn();
    		 ps=ct.prepareStatement("select passwd from user3 where username=?");
    		 ps.setString(1, u);
    		 rs=ps.executeQuery();
    		 if(rs.next())
    		 {
    			 String dbPasswd=rs.getString(1);
    			 if(dbPasswd.equals(p))
    			 {
    				 //合法用户
    				b=true; 
    			 }
    		 }
    		 
		  } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		 }finally{
			 this.close();
		 }
    	 return b;
     }
   //==============关闭资源方法===============
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
