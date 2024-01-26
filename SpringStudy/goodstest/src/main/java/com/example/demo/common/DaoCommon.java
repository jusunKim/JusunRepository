package com.example.demo.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //나는 AOP설정하는 클래스야
@Component //컨트롤러도 아니고.. 다오도 아니고? 그럼 component
public class DaoCommon {

	@Pointcut("execution (public * com.example.demo.dao.. * (..))") 
	public void pro() {} //daoBefore는 아이디의 역할을 하는 거. 타겟의 아이디가 pro인거임
		
	@Before("pro()") //beforeAdvice를 설정하겠다. 괄호 안에 포인트컷의 아이디를 써줘야함. 주의: 괄호까지써줘야함
	public void before() {
		System.out.println("pro 동작함!");
	}
}
