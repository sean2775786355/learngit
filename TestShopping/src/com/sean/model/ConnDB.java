//����һ��model��
//�������ݿ⣬�õ����ݿ�����
package com.sean.model;
import java.sql.*;
public class ConnDB {
    private Connection ct=null;
    
    public Connection getConn()
    {
    	try {
    		//��������
			Class.forName("com.mysql.jdbc.Driver");
			//�õ�����
			ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/t2", "root","067015");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
          return ct; 
    }
    
    
}
