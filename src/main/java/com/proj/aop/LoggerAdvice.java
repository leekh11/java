package com.proj.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(getClass()); 
	
	public void logging(JoinPoint joinPoint) {
		String clsName = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		Object[] objs = joinPoint.getArgs();
		
		logger.error("-----------------------------------------");
		for(Object o : objs	) {
			logger.debug("{}.{} args={}", clsName, methodName, o);
			
//			if(o instanceof List<?>) {
//				
//			}else if (o instanceof Map<? ,?>) {
//				
//			}else {
//				
//			}
		}
		logger.error("-----------------------------------------");
	}
	
}
