//�õ����ݿ�����
package com.sp.model;
import java.sql.*;
public class ConnDB {

	private Connection ct=null;
	public Connection getConn()
	{
		try{
			//1.��������
		    Class.forName("com.mysql.jdbc.Driver");
		    //�õ�����
            ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/t2","root","067015");
			
		}catch(Exception ex){
			
			//һ��д��
			
			ex.printStackTrace();
		}
		return ct;
	}
}
