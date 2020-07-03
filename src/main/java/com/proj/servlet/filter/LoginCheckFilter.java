package com.proj.servlet.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	
	private List<String> excludeList = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		excludeList = new ArrayList<String>();
		excludeList.add("/login/login.wow");
		excludeList.add("/login/logout.wow");
		excludeList.add("/free/freeList.wow");
		excludeList.add("/join/join.wow");
		
		excludeList.add("/member/memberList.wow");
		excludeList.add("/member/memberForm.wow");
		
	}

	@Override
	public void destroy() {
		excludeList = null;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//로그인 체크
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(false);	//true : 세션이 존재하지 않으면 생성을 해줌
														//false : 세션이 존재하지 않으면 null 리턴
		String uri = req.getRequestURI();				// /study3/login/login.wow
		uri = uri.substring(req.getContextPath().length());	// /login/login.wow
		
		if(excludeList.contains(uri)) {			//포함하고 있으면 넘어감(로그인체크안함)
			chain.doFilter(request, response);
		} else {
			if( session == null || session.getAttribute("USER_INFO") == null) {
				//return "redirect:/login/login.wow";
				System.out.println("로그인 체크에서 걸렸어요");
				//redirect : 클라이언트가 이동
//				((HttpServletResponse)response).sendRedirect(req.getContextPath() + "/login/login.wow");
				
				//RequestDispatcher : 서버 내부에서 이동
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
				rd.forward(request, response);
								
			} else {
				chain.doFilter(request, response);
			}
		}
	}
}
