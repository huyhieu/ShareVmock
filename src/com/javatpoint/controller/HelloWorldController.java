package com.javatpoint.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.viettel.util.LogUtils;
@Controller
public class HelloWorldController {
	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		LogUtils.d("hello", "/hello");
		String message = "Hello World, Spring MVC @ Javatpoint";
		return new ModelAndView("hello", "message", message);
	}
}
