package com.proj.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.exception.BizException;
import com.proj.exception.BizNotFoundException;
import com.proj.exception.BizPasswordNotMatchedException;
import com.proj.login.vo.UserVO;
import com.proj.member.dao.IMemberDao;
import com.proj.member.vo.MemberVO;

@Service
public class LoginServiceImpl  implements ILoginService{
	
	@Autowired
	private IMemberDao memberDao;
	
	@Override
	public UserVO loginCheck(UserVO user) throws BizException {
			MemberVO member = memberDao.getMember(user.getUserId());		
			if(member == null) {
				throw new BizNotFoundException("회원 [" + user.getUserId() + "] 조회 실패");
			}
			if( ! member.getMemPass().equals(user.getUserPass())) {
				throw new BizPasswordNotMatchedException("입력하시 패스워드가 올바르지 않습니다.");
			}
			UserVO vo = new UserVO();
			vo.setUserId(user.getUserId());
			vo.setUserPass(user.getUserPass());
			vo.setUserName(member.getMemName());
			vo.setUserRole("MEMBER");
			return vo;
	}
	@Override
	public UserVO loginCheckM(UserVO user) throws BizException {
			System.out.println(user.getUserId());
			System.out.println(user.getUserPass());
			UserVO vo = new UserVO();
			if(user.getUserId().equals("tour")  && user.getUserPass().equals("aaaa") ) {
				vo.setUserId(user.getUserId());
				vo.setUserPass(user.getUserPass());
				vo.setUserName("관리자");
				vo.setUserRole("Manager");
			}else {	
				throw new BizNotFoundException("관리자 [" + user.getUserId() + "] 조회 실패");
			}

			return vo;
	}

	@Override
	public void logout(UserVO user) throws BizException {
		
		
		
	}

}
