package com.me.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.me.pojo.Lover;
import com.me.pojo.User;
import com.me.service.LoverServiece;
import com.me.service.UserService;

@Controller
@SessionAttributes(types={User.class})
public class LoginController {
	
	@Autowired
	private UserService uService;
	@Autowired
	private LoverServiece lService;
	
	@ModelAttribute("user")
	public User setUser(@RequestParam("userid") Integer id,@RequestParam("password") String password) {
		if(id!=null&&password.equals("1")) {
			User user=uService.selectUserById(id);
			return user;	
		}
		else {
			return null;
		}
	}
	
	@ModelAttribute("lovers")
	public List<Lover> setLovers(@RequestParam("userid")Integer userid){
		if(userid!=null) {
			List<Lover> loverlist=lService.selectAllByUserId(userid);
			return loverlist;
		}
		else {
			return null;
		}
	}
	
	@RequestMapping(value="/come")
	public ModelAndView login(@ModelAttribute("user") User user) throws IOException {
		ModelAndView modelAndView=new ModelAndView();
		
		if(user==null) {
			modelAndView.setViewName("/error");
			return modelAndView;
		}
/*		Acc acc=new Acc();
		String str=acc.add();
		
		user.setName("ЦЦ");
		user.setHead(str);
		uService.updateUserById(user);*/
		
		modelAndView.setViewName("/main");
		return modelAndView;
	}
}
