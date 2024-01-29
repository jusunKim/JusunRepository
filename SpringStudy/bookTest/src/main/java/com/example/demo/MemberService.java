package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

@Service //이걸써야지 자도으로 스캔된다곻ㅁ..
public class MemberService implements UserDetailsService{

	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO m = dao.findByID(username);
		if(m==null) {
			throw new UsernameNotFoundException(username);//없으면 강제로 예외 발생시키기
		}
		//그게 아니면 UserDetails객체 생성
		UserDetails details = null;
		UserBuilder builder = User.builder();
		builder.username(m.getId());
		builder.password(m.getPwd());
		builder.roles(m.getRole());
		details = builder.build();
		
		System.out.println("loadUserByUsername동작함");
		System.out.println("회원아이디:"+username);
		return details;
	}
}
