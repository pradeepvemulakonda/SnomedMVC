package com.pradeep.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages="com.pradeep.hello")
public class GlobalExceptionController {

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleCustomException(RuntimeException ex) {

		ModelAndView model = new ModelAndView("error/error");
		model.addObject("errCode", 500);
		model.addObject("errMsg", ex.getLocalizedMessage());
		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "this is Exception.class");

		return model;

	}
	
}