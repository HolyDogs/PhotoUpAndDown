package com.me.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login.jsp";
	}
	
}
