package com.example.demo.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@Setter
public class MailController {
	
	@Autowired
	private JavaMailSender mailSender;
//	private MailSender mailSender;
	
	@GetMapping("/sendHTML")
	@ResponseBody
	public String sendHtml() {
		mailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");//true헤애파일감.
				
				String text = "<h2>회원가입 성공</h2>";
				text += "<hr>";
				text += "<table border='1'>";
				text += "<tr>";
				text += "<td>아이디</td>";
				text += "<td>tiger</td>";
				text += "<td>이름</td>";
				text += "<td>홍길동</td>";
				text += "</tr>";
				text += "</table>";
				text+= "<br><br>";
				text+= "<img src='cid:ball'>"; //컨텐트 아이디를 ball이라고 등록할거임
				
				message.setFrom("kimforward27@gmail.com");
				message.setTo("jusun627@naver.com");
				message.setSubject("회원가입이 완료됐습니다");
				message.setText(text, false); //불린은 html형식으로 볼낼거냐는 거
				
				//컨텐트아이디를 설정하기
				message.addInline("ball", new ClassPathResource("com/example/demo/sist/ball1.jpg")); //위에 cid:ball이라고 했잖아 r그거랑 경로
				//첨부파일 설정하기
				message.addAttachment("result.txt", new ClassPathResource("com/example/demo/sist/result.txt"));
			}
		});
		return "OK";
	}
	
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
