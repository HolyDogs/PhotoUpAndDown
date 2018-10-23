package com.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService uService;
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam("userid") Integer id) {
		System.out.println(id);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/main");
		return modelAndView;
	}
}
