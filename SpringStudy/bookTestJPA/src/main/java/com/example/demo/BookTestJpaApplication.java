package com.example.demo;

import java.lang.reflect.Method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookTestJpaApplication {

	public static void main(String[] args) {
		//문자열로 된 메소드 이름을 갖고 해당 메소드를 동작시키자
		String methodName = "sub";
		Test test = new Test();
		int r = 0;
		try {
			Class cls = Class.forName(test.getClass().getName());
			Method method =cls.getDeclaredMethod(methodName, Integer.class); //메소드객체반환
			r = (Integer)method.invoke(test, 5); //invoke를 통해 해당 메소드 실행. invoke는 object반환
			System.out.println("메소드실행결과"+r);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		SpringApplication.run(BookTestJpaApplication.class, args);
	}
}
