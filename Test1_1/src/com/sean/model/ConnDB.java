package com.sean.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDB {
	
   private Connection ct=null;
   
   public Connection getConn()
   {
	   try {
		 //加载驱动
		   Class.forName("com.mysql.jdbc.Driver");
		   //得到连接
		   ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/t2","root", "067015");
	    } catch (Exception e) {
		// TODO: handle exception
		  
		  e.printStackTrace();
	     }
	   return ct;
   }
}
