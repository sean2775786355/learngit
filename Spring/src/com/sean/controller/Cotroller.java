package com.sean.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sean.util.Descode;

@Controller
//Controller
@RequestMapping("/admin")
//RequestMapping拦截url
@SessionAttributes("talk")
public class Cotroller{

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("id","122");
		
		return "/admin/login";
		
		
		
	}
	
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public String loginPost(Model model,String username,String password){
		if("sean".equals(username) && "sean".equals(password)){
		   //转发
			model.addAttribute("aa","aaa");
			return "/ok";
		}
            //转发
	    	return "/fail";
	
	}
	@RequestMapping(value="/talk",method=RequestMethod.POST)
	public String talk(){
		return "/talk";
	}
	
	
	@RequestMapping(value="/deal",method=RequestMethod.POST)
	public String deal(String s_talk,ModelMap map) throws JSONException, UnsupportedEncodingException
	{
		String KEY ="8c0f86c1e66845458c468d5b888f3ac7";
		  String talk=s_talk;
		  StringBuffer sb = new StringBuffer(); 
		  try {
			talk= URLEncoder.encode(talk, "utf-8");
			  String INFO=talk;
			  URL url=new URL("http://www.tuling123.com/openapi/api?key=8c0f86c1e66845458c468d5b888f3ac7&info="+s_talk);
 	  // System.out.println(url);
 	 
 	   HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
 	   connection.connect();
 	   BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")); 
 	 
 	   String line = ""; 
 	   while ((line = reader.readLine()) != null) {  
			    sb.append(line);  
			}
 	   reader.close();
 	   connection.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
      String temp=s_talk.toString();
      temp= URLEncoder.encode(temp, "utf-8");
	   String str=sb.toString();
	   JSONObject json1=new  JSONObject(str);
	   if(str.contains("text"))
	   {
	     map.addAttribute("text",json1.get("text"));
	   }
	   if(str.contains("url"))
	   {
		   map.addAttribute("url",json1.get("url"));
	   }
	   
	   System.out.println(s_talk);
	   temp=Descode.descape(temp);
	   map.addAttribute("talk",s_talk);
	   System.out.println(sb);
	   return "/talk";
	}
		
	
	
}