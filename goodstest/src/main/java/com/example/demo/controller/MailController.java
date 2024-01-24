package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@Setter
public class MailController {
	
	@Autowired
	private MailSender mailSender;
	
	@GetMapping("/sendMail")
	@ResponseBody
	public String send() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("kimforward27@gmail.com");
		mailMessage.setTo("jusun627@naver.com");
		mailMessage.setSubject("메일 제목)메일 보내기 연습");
//		mailMessage.setText("메일 내용) 메일 잘 갔는가");
		
		//네자리 코드 만드는 법
		Random r= new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		String data = a+""+b+""+c+""+d;
		
		mailMessage.setText(data);
		try {
			mailSender.send(mailMessage);
		} catch (Exception e) {
			System.out.println("메일예외발생:"+e.getMessage());
		}
		return "OK";
	}
}
