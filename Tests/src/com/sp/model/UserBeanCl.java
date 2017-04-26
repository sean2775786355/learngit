//����һ�������࣬��Щ�˰�������Do����Ҫ�����users������ĸ���
//����������Ҫ������ɾ���ޣ��顣��������
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
    //��ֵͨ��pageSize��pageCount����
    private int rowCount=0;
    //�����û�ϣ����ʾ��ҳ��(pageNow)
    //==========================================================================
    //ɾ���û�
    public boolean deUserById(String id){
    	boolean b=false;
    	
    	try {
			//�õ�����
    		ct=new ConnDB().getConn();
    		//=====ִ��=======
    		
    		String sql="delete from user3 where id="+id+"";
			ps=ct.prepareStatement(sql);
			int num=ps.executeUpdate();
        if(num==1)
        {
        	//ɾ���ɹ�
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
    
    //==================����û�======================================================
    /**
     * @author sean
     * 
     * @param name:�û���
     * @param passwd������
     * @param s_age������
     * @param picture��ͷ��
     * @return boolean: ���ture��˵����ӳɹ������false:˵�����ɹ�
     */
    
    public boolean addUser(String name,String passwd,String s_age,String picture){
    	
    	
        boolean b=false;
    	
    	try {
		//�õ�����
    	ct=new ConnDB().getConn();
    	//=====ִ��=======
    	int age=Integer.parseInt(s_age);	
    	String sql="insert into user3 values(null,'name','passwd',age,'picture')";
	     ps=ct.prepareStatement(sql);
	     int num=ps.executeUpdate();
        if(num==1)
        {
        	//��ӳɹ�
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
    
    //=======================ɾ���û�=========================================
    
    //���ط�ҳ��ҳ��
    public int getPageCount()
    {     
    	
    	try{
    		
    		
		    		//�õ�����
		    		ct=new ConnDB().getConn();
		    		//������
		    		
		    		  //3.����Statement
		            ps=ct.prepareStatement("select count(*) from user3");
		            //4.��ѯ���ݿ�
		            rs=ps.executeQuery();
		            if(rs.next())
		            {
		                 rowCount=rs.getInt(1);
		                 
		            }
		            //����pageCount �����㷨�ܶ࣬�����Լ����
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
	//�õ��û���Ҫ��ʾ���û���Ϣ����ҳ��
     
	public ArrayList getUserByPage(int pageNow)
	{   
		
		
		ArrayList al=new ArrayList();
		try{
			 ct=new ConnDB().getConn();
	          
	          //��ѯ��Ҫ��ʾ�ļ�¼
	          ps=ct.prepareStatement("select * from user3 limit ?,5");
	          //����һ������ֵ
	          ps.setInt(1, pageSize*(pageNow-1));
	          rs=ps.executeQuery();
	          //��ʼ��rs��װ��ArrayList
	          while(rs.next())
	          {
	        	  UserBean ub=new UserBean();
	        	  ub.setId(rs.getInt(1));
	        	  ub.setUsername(rs.getString(2));
	        	  ub.setPasswd(rs.getString(3));
	        	  ub.setAge(rs.getInt(4));
	        	  ub.setPicturename(rs.getString(5));
                  //��ub���뵽ArrayList
	        	  al.add(ub);
	          }

		   
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			//�ر���Դ
			this.close();
		}
		return al;
	}
	
	
	
	//��֤�û��Ƿ�Ϸ�
	public boolean checkUser(String u,String p){
	
		
		boolean b=false;
		try {
			   //�����ݿ���֤
			    ct=new ConnDB().getConn();
			 
		        //3.����Statement
		        ps=ct.prepareStatement("select passwd from user3 where username=?");
		        ps.setString(1,u);
		        //4.��ѯ���ݿ�
		        rs=ps.executeQuery();
		       //���ݽ���ж�
		       if(rs.next())
		       { 
		         //˵���û�������
		         if(rs.getString(1).equals(p))
		         {
		            //�Ϸ�
		            b=true;
		         }else{
		            //�������
		            b=false;
		         }
		       }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�رմ򿪵ĸ�����Դ
			this.close();
			
		}
		return b;
		
		
		
	}
	//�ر���Դ����
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
