package com.proj.festival.service;

import java.util.List;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.festival.vo.FestivalVO;

public interface IFestivalService {
	public void registFestival(FestivalVO festival) throws BizException;
	public void modifyFestival(FestivalVO festival) throws BizException;
	public void removeFestival(FestivalVO festival) throws BizException;
	public FestivalVO getFestival(int no) throws BizException;
	public List<FestivalVO> getFestivalList(PagingVO vo) throws BizException;

}
