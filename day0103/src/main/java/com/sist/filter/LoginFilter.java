package com.sist.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/LoginFilter")
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("LoginFilter동작함.");
		
		//1.doFilter의 매개변수인 ServletRequest의 request를 HttpServletRequest로 형변환하여 session객체 얻어오기
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		//2.세션에 로그인 관련된 값 있는지 확인
		if(session.getAttribute("idKey")!=null) { //세션변수 idKey가 있다면(로그인을 했다면)
			chain.doFilter(request, response);//실제 요청된 서비스로 가라
		}else { //없다면(로그인안했다면)
			((HttpServletResponse)response).sendRedirect("/day0103/login.do"); //(member가 아니니까)컨텍스트 이름을 써줘야한대
			//doFilter메소드의 매개변수인 ServletResponse를 HttpServletResponse로 형변환해야지 sendRedirect를 쓸수잇음
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
