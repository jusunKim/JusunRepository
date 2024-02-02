package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/test1")
	public void test1(String name, int age) {
		System.out.println("이름:"+name+" 나이:"+age);
	}
	
	@GetMapping("/test2/{name}/{age}")
	public String test2(@PathVariable String name, @PathVariable int age) { //경로랑 같이 오는 변수야- 라고 알려줘야ㅑ댐
		System.out.println("이름:"+name+" 나이:"+age);
		return "test2"; //얘는 뷰를 따로 써줘야돼.. 요청한 거대로 찾을거아녀
	}
}
