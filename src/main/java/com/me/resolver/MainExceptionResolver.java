package com.me.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.me.exceptions.LoverException;
import com.me.exceptions.UserException;

public class MainExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Exception exception;
		if(ex instanceof UserException) {
			exception=(UserException) ex;
		}else if (ex instanceof LoverException) {
			exception=(LoverException) ex;
		}else {
			exception=new Exception("Î´Öª´íÎó");
		}
		
		String message=exception.getMessage();
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.setViewName("/error");

		return modelAndView;
	}

}
