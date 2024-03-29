package com.example.demo.util;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.dao.EmpDAO;
import com.example.demo.vo.EmpVO;

@Component //얘를 붙여줘야 SistUtil객체가 생성이 된대
@EnableScheduling
public class SistUtil {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	EmpDAO dao  = new EmpDAO();
//	@Scheduled(fixedRate = 10000) //옵션 fixedRate: 설정 시간마다 반복적으로 동작
	
//	@Scheduled(cron = "30 30 12 25 * ?")
	public void sendMail() {
		List<Integer> list = dao.listEno();
		for(int v :list) {
			EmpVO e = dao.findByEno(v);
			String name = e.getEname();
			String email = e.getEmail();
			int total = e.getSalary()+e.getComm();
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("jusun627@naver.com");
			mailMessage.setTo(email);
			mailMessage.setSubject("급여명세서: [담당자:김주선]");
			mailMessage.setText(name+"님, 2024년 1월 급여는 "+total+"만원 입니다");
			mailSender.send(mailMessage);
			System.out.println(e.getEname());
			System.out.println(total);
		}
		
	}
	
	@Autowired
	private JavaMailSender javaMailSender;
	
//	@Scheduled(cron = "30 25 12 25 * ?")
	public void sendMails() {
		List<Integer> list = dao.listEno();
		for(int v:list) {
			EmpVO e = dao.findByEno(v);
			int dno = e.getDno();
			String name = e.getEname();
			String email = e.getEmail();
			int salary = e.getSalary();
			int comm = e.getComm();
			int total = salary+comm;
		javaMailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
			
					
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					message.setFrom("kimforward27@gmail.com");
					message.setSubject("급여명세서: [담당자:김주선]");
					String str = "<h2>2024년 1월</h2>";
					str += "<table border='1'>";
					str += "<tr>";
					str += "<th>사원번호</th>";
					str += "<th>이름</th>";
					str += "<th>부서번호</th>";
					str += "<th>급여</th>";
					str += "<th>수당</th>";
					str += "<th>실수령액</th>";
					str += "</tr>";
					str += "<tr>";
					str += "<td>"+v+"</td>";
					str += "<td>"+name+"</td>";
					str += "<td>"+dno+"</td>";
					str += "<td>"+salary+"</td>";
					str += "<td>"+comm+"</td>";
					str += "<td>"+total+"</td>"; 
					str += "</tr>";
					str += "</table>";
					message.setText(str, true);
					message.setTo(email);
					
					System.out.println(v+" "+name+" "+total);
				
				
			}
		});
	}}
}
