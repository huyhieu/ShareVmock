package com.viettel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author hieuph
 *
 */
@Controller
//cach 1@RequestMapping("/hello")
public class HelloWorldController {
	
	// cach 2
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String sayHelloWorld(ModelMap model) {
		model.addAttribute("message", "Spring 4.01 MVC Framework Interceptor!");
		model.addAttribute("auther", "User not login");
		/*if(stUser!=null){
			model.addAttribute("auther", stUser.getUserEmail());
		}
		else {
			model.addAttribute("auther", "User not login");
		}*/
		return "hello";
	}
}
