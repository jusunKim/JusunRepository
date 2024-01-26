package com.example.demo.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerCommon {
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	public void controller() {};
	
	@Around("controller()")
	public Object dataLog(ProceedingJoinPoint joinPoint) {
		Object re = null;
		
		
		return re;
	}
}
