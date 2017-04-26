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
//Controller注解会在包扫描的时候被访问到
@SessionAttributes({"id","a","s"})
//将model中属性名字为id,a的再放入session中。这样request和session中都有了。
@RequestMapping("/sean")
//RequestMapping注解确定了拦截URL
public class Controller1{

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model,ModelMap map){
		model.addAttribute("id","122");
		map.addAttribute("name", "sean");
		map.put("a", "aaa");
		System.out.println("login");
		return "/sean/login02";
		//在login界面用    ${id};
		
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
	{ //  request.setAttribute("获得request", "HttpServeltRequest");
        //request.getSession().setAttribute("获得session", "session");
        //转发,不写forword也是转发
        //return "forward:index.jsp"
	    //System.out.println(s1);
//	    return "http://www.baidu.com";这样是不行的,转发只能是本站点，不能是其他的
	    //而重定向可以是其他网址
    	return "redirect:http://www.baidu.com";
		//重定向
	}
	
//	@RequestMapping(value="/test2")
//	public ModelAndView Mav(Model model)
//	{	
//		ModelAndView mav= new ModelAndView();
//	      //设置视图  
//		mav.setViewName("index");
//	       User u=new User("sean");
//	       //添加对象
//	       mav.addObject("user", u);
//	       mav.addObject(u);//访问用类名访问
//	       return mav;	
//	}
	@RequestMapping(params="method=test1")
	//用params属性
	public String test1(Model model)
	{
		return "/hello";
	}
	
}