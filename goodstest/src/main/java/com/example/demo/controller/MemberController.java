package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import kr.co.youiwe.webservice.BitSms;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO dao = new MemberDAO();

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private BitSms sms;
	
	@GetMapping("/sendCode")
	@ResponseBody
	public String sendCode(String to, String authType) {
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		String code = a+""+b+""+c+""+d;
		if(authType.equals("email")) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("kimforward27@gmail.com");
			mailMessage.setTo(to);
			mailMessage.setSubject("[이메일 인증]");
			mailMessage.setText(code);
			
			mailSender.send(mailMessage);
		}else {
			sms.sendMsg("01025598279", to, code);
		}
		return code;
	}
	
	@GetMapping("/sendSms")
	@ResponseBody
	public String sendSms(String phone) {
		String from = "01025598279";
		String to = phone;
		
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		String msg = a+""+b+""+c+""+d;
		
		sms.sendMsg(from, to, msg);
		return msg;
	}
	
	@GetMapping("/sendCodeEmail")
	@ResponseBody //ajax통신 요청바데이터를 응답할거니까 responseBody
	public String sendCodeEmail(String email) {
		String code="";
		
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		code = a+""+b+""+c+""+d;
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("kimforward27@gmail.com");
		mailMessage.setTo(email);
		mailMessage.setSubject("[이메일 인증]");
		mailMessage.setText(code);
		
		mailSender.send(mailMessage);
		return code;
	}

	@GetMapping("/join")
	public void joinForm() {
		
	}
	
	@PostMapping("/join")
	@ResponseBody
	public String submit(MemberVO m) {
		dao.joinMember(m);
		return "OK";
	}
	
}
