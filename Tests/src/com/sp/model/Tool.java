package com.sp.model;

public class Tool {

	public static String getNeuString(String input){
	   
		
		String result="";
		try{
			result=new String(input.getBytes("iso-8859-1"),"gbk");
		}catch(Exception e){
              e.getStackTrace();			
		}
		return result;
		
	}
	
	
}
