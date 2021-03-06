package com.pradeep.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter{
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ExecuteTimeInterceptor.class);

	//before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request, 
		HttpServletResponse response, Object handler)
	    throws Exception {
		
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		return true;
	}

	//after the handler is executed
	public void postHandle(
		HttpServletRequest request, HttpServletResponse response, 
		Object handler, ModelAndView modelAndView)
		throws Exception {
		if(modelAndView == null) {
			modelAndView = new ModelAndView();
		}
		long startTime = (Long)request.getAttribute("startTime");
		
		long endTime = System.currentTimeMillis();

		long executeTime = endTime - startTime;
		
		//modified the exisitng modelAndView
		modelAndView.addObject("executeTime",executeTime);
		
		System.out.println("IN the post handler");
		
		//log it
		if(logger.isDebugEnabled()){
		   logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
		}
	}
}