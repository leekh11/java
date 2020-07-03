package com.proj.stay.service;

import java.util.List;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.stay.vo.StayVO;

public interface IStayService {
	public void registStay(StayVO stay) throws BizException;
	public void modifyStay(StayVO stay) throws BizException;
	public void removeStay(StayVO stay) throws BizException;
	public StayVO getStay(int no) throws BizException;
	public List<StayVO> getStayList(PagingVO vo) throws BizException;

}
