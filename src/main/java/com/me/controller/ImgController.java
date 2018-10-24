package com.me.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.me.pojo.User;
import com.me.service.UserService;

@Controller
@RequestMapping("/img")
public class ImgController {
	
	@RequestMapping("/gethead")
	public void getHead(HttpServletRequest request,HttpServletResponse response) {
		User user=(User) request.getSession().getAttribute("user");
		byte data[]=Base64.getDecoder().decode(user.getHead());
		OutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/update")
	public void updateHead(HttpServletRequest request,HttpServletResponse response) {
		MultipartResolver resolver=new CommonsMultipartResolver(request.getSession().getServletContext());
		if(resolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest=resolver.resolveMultipart(request);
			Iterator iterator=multipartHttpServletRequest.getFileNames();
			while (iterator.hasNext()) {
				MultipartFile file=multipartHttpServletRequest.getFile(iterator.next().toString());
				if (file!=null) {
					try {
						byte data[]=file.getBytes();
						String str=Base64.getEncoder().encodeToString(data);
						User user=(User) request.getSession().getAttribute("user");
						user.setHead(str);
						userService.updateUserById(user);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	
}
