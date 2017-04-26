//这是一个处理类，有些人把它叫做Do，主要是针对users表操作的各种
//操作，（主要是增，删，修，查。。。。）
package com.sp.model;
import java.util.*;
import java.sql.*;

import javax.servlet.jsp.tagext.TryCatchFinally;

public class UserBeanCl {
	
	
	
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private Connection ct=null;
	private int pageSize=3;
    private int pageCount=0;
    //该值通过pageSize和pageCount计算
    private int rowCount=0;
    //接受用户希望显示的页数(pageNow)
    //==========================================================================
    //删除用户
    public boolean deUserById(String id){
    	boolean b=false;
    	
    	try {
			//得到连接
    		ct=new ConnDB().getConn();
    		//=====执行=======
    		
    		String sql="delete from user3 where id="+id+"";
			ps=ct.prepareStatement(sql);
			int num=ps.executeUpdate();
        if(num==1)
        {
        	//删除成功
        	b=true;
        }
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
		   this.close();	
			
		}
    	
    	return b;
    }
    
    //==================添加用户======================================================
    /**
     * @author sean
     * 
     * @param name:用户名
     * @param passwd：密码
     * @param s_age：年龄
     * @param picture：头像
     * @return boolean: 如果ture：说明添加成功，如果false:说明不成功
     */
    
    public boolean addUser(String name,String passwd,String s_age,String picture){
    	
    	
        boolean b=false;
    	
    	try {
		//得到连接
    	ct=new ConnDB().getConn();
    	//=====执行=======
    	int age=Integer.parseInt(s_age);	
    	String sql="insert into user3 values(null,'name','passwd',age,'picture')";
	     ps=ct.prepareStatement(sql);
	     int num=ps.executeUpdate();
        if(num==1)
        {
        	//添加成功
        	b=true;
        }
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
		   this.close();	
			
		}
    	
    	return b;
    }
    
    
    
    //=======================================================================
    
    //=======================删除用户=========================================
    
    //返回分页总页数
    public int getPageCount()
    {     
    	
    	try{
    		
    		
		    		//得到连接
		    		ct=new ConnDB().getConn();
		    		//计算结果
		    		
		    		  //3.创建Statement
		            ps=ct.prepareStatement("select count(*) from user3");
		            //4.查询数据库
		            rs=ps.executeQuery();
		            if(rs.next())
		            {
		                 rowCount=rs.getInt(1);
		                 
		            }
		            //计算pageCount 这里算法很多，可以自己设计
		            if(rowCount%pageSize==0)
		            {
		                 pageCount=rowCount/pageSize;
		            }else{
		                 pageCount=rowCount/pageSize+1;
		            }
            
 
    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}finally{
		    		this.close();
		    	}
    	
    	return pageCount;
    }
	//得到用户需要显示的用户信息（分页）
     
	public ArrayList getUserByPage(int pageNow)
	{   
		
		
		ArrayList al=new ArrayList();
		try{
			 ct=new ConnDB().getConn();
	          
	          //查询需要显示的记录
	          ps=ct.prepareStatement("select * from user3 limit ?,5");
	          //给第一个？赋值
	          ps.setInt(1, pageSize*(pageNow-1));
	          rs=ps.executeQuery();
	          //开始讲rs封装到ArrayList
	          while(rs.next())
	          {
	        	  UserBean ub=new UserBean();
	        	  ub.setId(rs.getInt(1));
	        	  ub.setUsername(rs.getString(2));
	        	  ub.setPasswd(rs.getString(3));
	        	  ub.setAge(rs.getInt(4));
	        	  ub.setPicturename(rs.getString(5));
                  //讲ub放入到ArrayList
	        	  al.add(ub);
	          }

		   
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			//关闭资源
			this.close();
		}
		return al;
	}
	
	
	
	//验证用户是否合法
	public boolean checkUser(String u,String p){
	
		
		boolean b=false;
		try {
			   //到数据库验证
			    ct=new ConnDB().getConn();
			 
		        //3.创建Statement
		        ps=ct.prepareStatement("select passwd from user3 where username=?");
		        ps.setString(1,u);
		        //4.查询数据库
		        rs=ps.executeQuery();
		       //根据结果判断
		       if(rs.next())
		       { 
		         //说明用户名存在
		         if(rs.getString(1).equals(p))
		         {
		            //合法
		            b=true;
		         }else{
		            //密码错误
		            b=false;
		         }
		       }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭打开的各种资源
			this.close();
			
		}
		return b;
		
		
		
	}
	//关闭资源函数
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
	//
	
}
