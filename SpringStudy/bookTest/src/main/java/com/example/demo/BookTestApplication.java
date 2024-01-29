package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVO;

@SpringBootApplication
public class BookTestApplication {
	
	@Bean //나는 객체제공자야
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	public static void main(String[] args) {
		/*
		 * MemberVO m = new MemberVO(); m.setId("tiger");
		 * m.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(
		 * "tiger")); //걍 글자 쓰면 안되고 인코딩 해서 ㅇ넣어야지 m.setName("관리자"); m.setRole("admin");
		 * DBManager.insert(m); System.out.println("관리자 계정 생성함");
		 *///이거 걍 관리자 권한 가진 아이디 만들라고 한 거.
		SpringApplication.run(BookTestApplication.class, args);
	}

}

