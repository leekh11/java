package com.proj.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.member.vo.MemberSearchVO;
import com.proj.member.vo.MemberVO;



@Mapper
public interface IMemberDao {
	
	public int InsertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(MemberSearchVO searchVO);
	public MemberVO getMember(String memId);
	public List<MemberVO> getMemberList(MemberSearchVO searchVO);
	public List<MemberVO> getMemberListM(MemberSearchVO searchVO);
	public int getMemberCount(MemberSearchVO searchVO);
	
}
