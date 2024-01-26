package com.example.demo.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //나는 AOP설정하는 클래스야
@Component //컨트롤러도 아니고.. 다오도 아니고? 그럼 component
public class DaoCommon {

	@Pointcut("execution (public * com.example.demo.dao..*(..))") 
	public void pro() {} //타깃 아이디가 pro
	
	/*
	 * @Around("pro()") public Object around(ProceedingJoinPoint joinPoint) {
	 * //around는 매개변수가 반드시필요 PJP String methodName =
	 * joinPoint.getSignature().toShortString();
	 * System.out.println(methodName+"이 동작하기 전입니다."); Object re = null; long start =
	 * System.currentTimeMillis(); //현재시간을 밀리세컨으로 알려줌 try { re =
	 * joinPoint.proceed();//타깃을 동작시키는 명령. 얘 기준으로 앞에는 그전에할일, 후에는 그후할일 } catch
	 * (Throwable e) { e.printStackTrace(); }
	 * System.out.println(methodName+"이 동작한 후입니다."); long end =
	 * System.currentTimeMillis(); long delay = end-start;
	 * System.out.println("걸린 시간:"+delay); return re; }
	 */
	
	/*
	 * @After("pro()") public void after(JoinPoint joinPoint) { String methodName =
	 * joinPoint.getSignature().toShortString();
	 * System.out.println(methodName+"완료되었습니다"); }
	 */
	
	/*
	 * @AfterThrowing("pro()") public void afterThrowing(JoinPoint joinPoint) {
	 * String methodName = joinPoint.getSignature().toShortString();
	 * System.out.println(methodName+"동작 중에 문제가 발생했습니다"); }
	 */
	
	/*
	 * @AfterReturning("pro()") public void afterReturn(JoinPoint joinPoint) {
	 * //JoinPoint로 정보 가져올수있다 String methodName1 =
	 * joinPoint.getSignature().toShortString(); //메소드머리통인 시그니처, String methodName2
	 * = joinPoint.getSignature().toLongString(); //메소드머리통인 시그니처,
	 * System.out.println(methodName1); System.out.println(methodName2);
	 * System.out.println("타깃 메소드가 정상 완료되었습니다"); }
	 */
	
	/*
	 * @Before("pro()") //beforeAdvice를 설정하겠다. 괄호 안에 포인트컷의 아이디를 써줘야함. 주의: 괄호까지써줘야함
	 * public void before() { System.out.println("pro 동작함!"); }
	 */
	
	
}
