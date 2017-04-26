package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//Controller注解会在包扫描的时候被访问到
@RequestMapping("/user")
//RequestMapping注解确定了拦截URL
public class ControllerDemo {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("id","122");
		return "/user/login";
		//在login界面用    ${id};
		
	}
	
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public String loginPost(Model model,String username,String password){
		if("safewind".equals(username) && "java".equals(password)){
			return "/index";
		}
		return "/fail";
	}
	
}
