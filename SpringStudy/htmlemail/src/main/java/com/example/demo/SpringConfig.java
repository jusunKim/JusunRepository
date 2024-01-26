package com.example.demo;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;



@Configuration
public class SpringConfig {
	
	
	
	@Bean //나는 객체 제공자로서의 메소드야
	public JavaMailSenderImpl javaMailSender() {
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		jms.setHost("smtp.gmail.com");
		jms.setPort(587); //지메일
		jms.setUsername("kimforward27"); //아이디
		jms.setPassword("zhdu qhyw jcll xfqq");
		jms.setDefaultEncoding("UTF-8");
		
		Properties prop = new Properties();
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.checkserveridentity", true);
		prop.put("mail.smtp.ssl.trust", "*");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		jms.setJavaMailProperties(prop);
		
		return jms;
	}
}
