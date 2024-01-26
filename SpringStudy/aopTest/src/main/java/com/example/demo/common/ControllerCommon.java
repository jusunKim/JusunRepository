package com.example.demo.common;

import java.io.FileWriter;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Aspect
public class ControllerCommon {
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	public void controller() {};
	
	@Around("controller()")
	public Object fileLog(ProceedingJoinPoint joinPoint) {
		Object re = null;
		
		Object[] args =  joinPoint.getArgs(); // 타겟메소드의 매개변수 목록 배열로 가져옴
		HttpServletRequest request = (HttpServletRequest)args[0]; //매개변수 첫번째를 다 httpservletRequest로 해놔가지고
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		long start = System.currentTimeMillis();
		Date date = new Date(start); //밀리세컨드로 현재 시각 표현할수있삼
		String time = date.toLocaleString(); //요청시각
		try {
			re = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		long delay =end-start;
		
		String row = uri+"/"+ip+"/"+time+"/"+delay+"\n";
		System.out.println(row);
		
		try {
			int year = date.getYear()+1900;
			int month = date.getMonth()+1;
			int day = date.getDate();
			
			String fname = "c:/sist_log/";
			fname += year;
			if(month<10) {
				fname+="0";
			}
			fname+=month;
			if(day<10) {
				fname+="0";
			}
			fname+=day+".txt";
			
			//파일 작성
			FileWriter fw = new FileWriter(fname, true); //boolean 값 매개변수 true하면 ->이미 있는 파일에 추가
			fw.write(row);
			fw.close();
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
}
