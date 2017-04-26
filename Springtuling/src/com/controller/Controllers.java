package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.omg.CORBA.portable.InputStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/GoodOne")
//拦截url
public class Controllers {
          @RequestMapping(value="/login",method=RequestMethod.GET)
          public String login(Model model)
          {
        	  return "/GoodOne/login";
        	  
          }
          @RequestMapping(value="/loginPost",method=RequestMethod.POST)
         public String loginPost(Model model,String username,String password)
          {   if("hello".equals(username)&&"hello".equals(password))
		          {
        	       return "/GoodOne/send";
		          }
                   return "/GoodOne/login";
          }
          
          @RequestMapping(value="/logintalk",method=RequestMethod.POST)
          public String loginPost(ModelMap map,String talk) throws IOException
          {   
        	  
        	  String KEY ="8c0f86c1e66845458c468d5b888f3ac7";
        	  String INFO=talk;
        	  System.out.println(talk);
        	  //将talk转化为utf-8编码否者InFO无法输入到tuling url中
        	  INFO = URLEncoder.encode(talk, "utf-8"); 
        	  URL url=new URL("http://www.tuling123.com/openapi/api?key="+KEY+"&info="+INFO);
     
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
        	  int a1=sb.indexOf(":");
        	  //得到数据code数字
        	  String s1=sb.substring(++a1, a1+6);
        	  //验证数据类型
        	  String str1=null;
        	  if(s1.equals("100000"))
        	  {  
        		 //文本型
        		 int b1=sb.indexOf("text");
        		 int c1=sb.lastIndexOf("\"");
        		 b1+=7;
        		 str1=sb.substring(b1,c1);
                 System.out.println(str1);       		 
      	  }
//        	  else if(s1.equals("200000"))
//        	  {
//                  //  链接类
//        		 int b1=sb.indexOf("text");
//         		 int c1=sb.lastIndexOf("\"");
//         		 b1+=7;
//         		 str1=sb.substring(b1,c1);
//                
//        		  
//        	  }
        	  //else if(s1.equals("302000"))
//        	  {  
//        		  //新闻类
//        		  
//        	  }else if(s1.equals("308000"))
//        	  {
//        		 //菜谱类
//        	  }else if(s1.equals("313000"))
//        	  {
//        		  
//        	  }else if(s1.equals(""))
//        	  {
//        		  //诗词类
//        	  }
        	
              map.addAttribute("text",str1);
                return "/GoodOne/send";
              
          }
  
        	    
        	    
        	  
          
}
