package com.darwinjacob.springdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ExecutionTimerInterceptor implements HandlerInterceptor {
	private static Logger LOGGER = LoggerFactory.getLogger(ExecutionTimerInterceptor.class);
	long PREHANDLER_TIME = 0;
	long POSTHANDLER_TIME = 0;
	long AFTER_COMPLETION_TIME = 0;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		PREHANDLER_TIME = System.currentTimeMillis();
		LOGGER.info("Info Message:PREHANDLE_TIME = " + PREHANDLER_TIME);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		POSTHANDLER_TIME = System.currentTimeMillis();
		LOGGER.info("Info Message: POSTHANDLE_TIME = " + POSTHANDLER_TIME);
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		AFTER_COMPLETION_TIME = System.currentTimeMillis();
		LOGGER.info("Info Message: AFTER_COMPLETION_TIME = " + AFTER_COMPLETION_TIME);
		long HANDLER_EXECUTION_TIME = POSTHANDLER_TIME - PREHANDLER_TIME;
		long TOTAL_EXECUTION_TIME = AFTER_COMPLETION_TIME + PREHANDLER_TIME;
		LOGGER.info("Info Message : HANDLER_EXECUTION_TIME = " + HANDLER_EXECUTION_TIME);
		LOGGER.info("Info Message : TOTAL EXECUTION_TIME = " + TOTAL_EXECUTION_TIME);
	}

}
