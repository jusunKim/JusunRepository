package com.example.demo.common;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.SistLogDAO;
import com.example.demo.vo.SistLogVO;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Aspect
public class SistCommon {
	
	@Autowired
	SistLogDAO dao = new SistLogDAO();
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))") //접근명시자, 반환값, 패키지, 메소드(매개변수)
	public void controller() {}; //얘가 타깃
	
	@Around("controller()")
	public Object dataLog(ProceedingJoinPoint joinPoint) {
		Object re = null;
		
		Object[] args = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest)args[0];
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		long start = System.currentTimeMillis();
		Date date = new Date(start);
		String time = date.toLocaleString();
		String method = joinPoint.getSignature().toShortString(); //쌤이 getName()으로 하셧는디..?멎
		
		try {
			re = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		int delay = (int)(end-start);
		
		SistLogVO a = new SistLogVO(0, uri, ip, method, time, delay);
		dao.insert(a);
		
		return re;
	}
}
