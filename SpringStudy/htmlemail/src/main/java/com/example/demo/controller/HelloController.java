package com.example.demo.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@Setter
public class HelloController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@GetMapping("/send")
	@ResponseBody
	public String send() {
		javaMailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				message.setFrom("kimforward27@gmail.com");
				message.setTo("jusun627@naver.com");
				String str = "<h2>hello</h2>";
				str+= "<table border='1'>";
				str+= "<tr>";
				str+= "<td>홍길동</td>";
				str+= "<td>서울시 마포구 서교동</td>";
				str+= "</tr>";
				str+= "</table>";
				str+= "<hr>";
				str+= "<img src='cid:ball'>";
				message.setText(str, true); //html방식으로 설정하겟다
				message.setSubject("html메일테스트");
				message.addInline("ball", new ClassPathResource("com/example/demo/img/ball1.jpg"));
			}
		});
		return "OK";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
}
