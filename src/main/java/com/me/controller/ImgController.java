package com.me.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.me.pojo.User;

@Controller
@RequestMapping("/img")
public class ImgController {
	
	@RequestMapping("/gethead")
	public void getHead(HttpServletRequest request,HttpServletResponse response) {
		User user=(User) request.getSession().getAttribute("user");
		System.out.println(user.getHead());
		byte data[]=Base64.getDecoder().decode(user.getHead());
		System.out.println();
		OutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
