package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//Controllerע����ڰ�ɨ���ʱ�򱻷��ʵ�
@RequestMapping("/user")
//RequestMappingע��ȷ��������URL
public class ControllerDemo {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("id","122");
		return "/user/login";
		//��login������    ${id};
		
	}
	
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public String loginPost(Model model,String username,String password){
		if("safewind".equals(username) && "java".equals(password)){
			return "/index";
		}
		return "/fail";
	}
	
}
