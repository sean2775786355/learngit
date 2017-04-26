package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

public class Test1 {

	public static void main(String[] args) throws IOException, JSONException {
		// TODO Auto-generated method stub
		  String KEY ="8c0f86c1e66845458c468d5b888f3ac7";
		  String talk="今天大连天气";
		 
		  talk= URLEncoder.encode(talk, "utf-8");
		  String INFO=talk;
	 	  URL url=new URL("http://www.tuling123.com/openapi/api?key=8c0f86c1e66845458c468d5b888f3ac7&info="+INFO);
    	  // System.out.println(url);
    	 
    	  HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
    	  connection.connect();
    	  BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")); 
    	  StringBuffer sb = new StringBuffer(); 
    	  String line = ""; 
    	  while ((line = reader.readLine()) != null) {  
              sb.append(line);  
          }
    	  reader.close();
    	  connection.disconnect();  
    	  System.out.println(sb);
//    	  int a2=sb.indexOf(":");
//    	  String s1=sb.substring(++a2, a2+6);
//    	  System.out.println(s1);
//    	  if(s1.equals("100000"))
//    	  {
//    		  String s2=sb.substring(23);
//    		  System.out.println(s2);
//    		 
//    		  System.out.println(a2);
//    		  int a=s2.indexOf("}");
//    		  a--;
//    		  String s3=s2.substring(0, a);
//    		  System.out.println(a+"lenth="+s2.length());
//    		  System.out.println(s3);
//    		  int b=sb.indexOf("text");
//    		  String s4=sb.substring(b+7);
//    		  System.out.println(b);
//    		  int a1=s2.lastIndexOf("\"");
//    		  System.out.println(a1);
//    		  System.out.println(s4);
//    		  String ss=s2.substring(b+7,a1);
//    		  System.out.println(ss);
//    		  
//    	  }else if(s1.equals("200000"))
//    	  {   
//    		  String s2;
//    		  //String s2=sb.substring();
//    		  
//    	  }
//		 
    	    String str=sb.toString();
		
			JSONObject json1=new  JSONObject(str);
			
			System.out.println(json1.getString("text"));
	
		
		}

}
