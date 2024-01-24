package com.example.demo.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
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
	
//	@Scheduled(cron = "30 46 16 24 * ?")
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
}
