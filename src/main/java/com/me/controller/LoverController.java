package com.me.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
