package com.proj.member.service;

import java.util.List;

import com.proj.member.vo.MemberSearchVO;
import com.proj.member.vo.MemberVO;

public interface IMemberService {
	
	public void registMember(MemberVO member); 
	public void modifyMember(MemberVO member); 
	public void removeMember(MemberSearchVO searchVO); 

	public MemberVO getMember(String memId);
	
	public List<MemberVO> getMemberList(MemberSearchVO searchVO);
	public List<MemberVO> getMemberListM(MemberSearchVO searchVO);

	
}
