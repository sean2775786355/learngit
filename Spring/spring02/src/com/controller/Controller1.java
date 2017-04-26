package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

@Controller
//Controllerע����ڰ�ɨ���ʱ�򱻷��ʵ�
@SessionAttributes({"id","a","s"})
//��model����������Ϊid,a���ٷ���session�С�����request��session�ж����ˡ�
@RequestMapping("/sean")
//RequestMappingע��ȷ��������URL
public class Controller1{

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model,ModelMap map){
		model.addAttribute("id","122");
		map.addAttribute("name", "sean");
		map.put("a", "aaa");
		System.out.println("login");
		return "/sean/login02";
		//��login������    ${id};
		
	}
	
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public String loginPost(Model model,@RequestParam("username")String name,String password){
		System.out.println("loginPost");
		model.addAttribute("s", "123");
		model.addAttribute("m", "hhahenen");
		if("safewind".equals(name) && "java".equals(password)){
			return "/ok";
		}
		return "/error";
	}
	
	@RequestMapping(value="/hello")
	public String hello(Model model,@ModelAttribute("") String s1,HttpServletRequest request)
	{ //  request.setAttribute("���request", "HttpServeltRequest");
        //request.getSession().setAttribute("���session", "session");
        //ת��,��дforwordҲ��ת��
        //return "forward:index.jsp"
	    //System.out.println(s1);
//	    return "http://www.baidu.com";�����ǲ��е�,ת��ֻ���Ǳ�վ�㣬������������
	    //���ض��������������ַ
    	return "redirect:http://www.baidu.com";
		//�ض���
	}
	
//	@RequestMapping(value="/test2")
//	public ModelAndView Mav(Model model)
//	{	
//		ModelAndView mav= new ModelAndView();
//	      //������ͼ  
//		mav.setViewName("index");
//	       User u=new User("sean");
//	       //��Ӷ���
//	       mav.addObject("user", u);
//	       mav.addObject(u);//��������������
//	       return mav;	
//	}
	@RequestMapping(params="method=test1")
	//��params����
	public String test1(Model model)
	{
		return "/hello";
	}
	
}