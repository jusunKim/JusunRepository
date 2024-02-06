package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Service
@Setter
public class MemberService implements UserDetailsService {
   
   @Autowired
   public MemberDAO dao;
   
   public Member findById(String id) {
	   return dao.findById(id).get();
   }
   
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      
//      dao.save(new Member("kim","김유신",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("kim"),"user"));
//      dao.save(new Member("lee","이순신",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("lee"),"user"));
//      dao.save(new Member("hong","홍길동",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("hong"),"admin"));
      
//      Member lee = new Member();
//      lee.setId("lee");
//      lee.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("lee"));
//      lee.setRole("user");
//      lee.setName("이순신");
//      dao.save(lee);
      Member kim = new Member();
      kim.setId("kim");
      kim.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("kim"));
      kim.setRole("user");
      kim.setName("김유신");
      dao.save(kim);
//      Member hong = new Member();
//      hong.setId("hong");
//      hong.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("hong"));
//      hong.setRole("admin");
//      hong.setName("홍길동");
//      dao.save(hong);
      

      
      System.out.println("회원을 추가했습니다.");
      
      Member m = dao.findById(username).get();
      if(m == null) {
         throw new UsernameNotFoundException(username);
      } 
      UserDetails user = null;
      user = User.builder()
               .username(m.getId())
               .password(m.getPwd())
               .roles(m.getRole())
               .build();
      return user;
   }

}