package com.me.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.pojo.Lover;
import com.me.pojo.User;
import com.me.service.LoverServiece;

@Controller
@RequestMapping("/lover")
public class LoverController {

	@Autowired
	private LoverServiece loverServiece;
	
	@RequestMapping("/deleteL")
	public void deleteL(Integer id,HttpServletResponse response) throws IOException {
		loverServiece.deleteLoverById(id);
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer=response.getWriter();
		writer.write("É¾³ý³É¹¦");
	}
	
	@RequestMapping("/randomImg")
	public String createImg(HttpServletRequest request,@RequestParam("btn") Integer id) {
		request.getSession().setAttribute("loverid", id);
		return "/thepic";
	}
	
	@RequestMapping("/back")
	public ModelAndView back(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		User u=(User) request.getSession().getAttribute("user");
		List<Lover> loverlist=loverServiece.selectAllByUserId(u.getId());
		modelAndView.addObject("lovers", loverlist);
		modelAndView.setViewName("/main");
		return modelAndView;
	}
	
	@RequestMapping("/addl")
	public void addl(@RequestParam("lname") String name,@RequestParam("month") String month,@RequestParam("day") String day,@RequestParam("year")String year,HttpServletRequest request,PrintWriter writer) throws ParseException {
		User user=(User) request.getSession().getAttribute("user");
		Lover lover=new Lover();
		lover.setUserid(user.getId());
		lover.setName(name);
		lover.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse(year+"-"+month+"-"+day));
		loverServiece.saveLover(lover);
		writer.write(name);
	}
}
