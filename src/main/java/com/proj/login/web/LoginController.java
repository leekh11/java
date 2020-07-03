package com.proj.login.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proj.common.vo.ResultMessageVO;
import com.proj.exception.BizNotFoundException;
import com.proj.exception.BizPasswordNotMatchedException;
import com.proj.login.service.ILoginService;
import com.proj.login.vo.UserVO;

@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService ;

	// /login/login.wow GET -> 로그인 화면
	// /login/login.wow POST -> 로그인 처리
	// /login/logout.wow -> 로그아웃 처리

	@RequestMapping("/login/login.wow")
	public String login() throws Exception {
		return "login/login";
	}

	@RequestMapping(value = "/login/login.wow", method = RequestMethod.POST)
	public String loginCheck(UserVO user, HttpSession session, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		try {
			UserVO vo = loginService.loginCheck(user);
			// 세션에 저장 및 쿠키처리
			session.setAttribute("USER_INFO", vo);
			return "redirect:/";
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("로그인 실패").setMessage("해당 회이 존재하지 않습니다.").setUrl("/join/join.wow")
					.setUrlTitle("회원가입");

			model.addAttribute("messageVO", messageVO);
			return "common/message";
		} catch (BizPasswordNotMatchedException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("로그인 실패").setMessage("비밀번호를 올바르지 않습니다.").setUrl("/join/join.wow")
					.setUrlTitle("비밀번호 찾기");

			model.addAttribute("messageVO", messageVO);
			return "common/message";
		}
	}

	@RequestMapping("/login/logout.wow")
	public String logout(UserVO user, HttpSession session) throws Exception {
		// 세션에서 USER_INFO를 꺼내어
		UserVO vo = (UserVO) session.getAttribute("USER_INFO");
		// USER_INFO가 널이 아니면 서비스의 logout 콜
		if (vo != null) {
			loginService.logout(vo);
		}
		// 세션 무효화(파기)
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/login/loginM.mg")
	public String loginM() throws Exception {
		return "login/loginM";
	}

	@RequestMapping(value = "/login/loginM.mg", method = RequestMethod.POST)
	public String loginCheckM(UserVO user, HttpSession session, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		try {
			UserVO vo = loginService.loginCheckM(user);
			// 세션에 저장 및 쿠키처리
			session.setAttribute("USER_INFO", vo);
			return "manager";
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("로그인 실패").setMessage("해당 회원이 존재하지 않습니다.").setUrl("/join/join.wow")
					.setUrlTitle("회원가입");

			model.addAttribute("messageVO", messageVO);
			return "common/message";
		} catch (BizPasswordNotMatchedException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("로그인 실패").setMessage("비밀번호를 올바르지 않습니다.").setUrl("/join/join.wow")
					.setUrlTitle("비밀번호 찾기");

			model.addAttribute("messageVO", messageVO);
			return "common/message";
		}
	}

	@RequestMapping("/login/logoutM.mg")
	public String logoutM(UserVO user, HttpSession session) throws Exception {
		// 세션에서 USER_INFO를 꺼내어
		UserVO vo = (UserVO) session.getAttribute("USER_INFO");
		// USER_INFO가 널이 아니면 서비스의 logout 콜
		if (vo != null) {
			loginService.logout(vo);
		}
		// 세션 무효화(파기)
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/mypage/myinfo.wow")
	@ResponseBody
	public UserVO myinfo(UserVO user, HttpSession session) throws Exception {
		// 세션에서 USER_INFO를 꺼내어
		UserVO vo = (UserVO) session.getAttribute("USER_INFO");
		vo.getUserName();
		vo.getUserName();
		return vo ;
	}
	
	
	

}