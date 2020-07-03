package com.proj.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.exception.BizNotEffectedException;
import com.proj.exception.BizNotFoundException;
import com.proj.festival.dao.IFestivalDao;
import com.proj.festival.vo.FestivalVO;

@Service
public class FestivalServiceImpl implements IFestivalService {

	@Autowired
	private IFestivalDao festivalDao;

	@Override
	public void registFestival(FestivalVO festival) throws BizException {
		try {
		int cnt = festivalDao.InsertFestival(festival);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", festival);
		}
		}catch (DuplicateKeyException e) {
			throw new DuplicateKeyException(e.getMessage(), e);
		}
	}

	@Override
	public void modifyFestival(FestivalVO festival) throws BizException {
		int cnt = festivalDao.updateFestival(festival);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", festival);
		}		
	}

	@Override
	public void removeFestival(FestivalVO festival) throws BizException {
		festivalDao.deleteFestival(festival);		
	}

	@Override
	public FestivalVO getFestival(int no) throws BizException {
		FestivalVO festival = festivalDao.getFestival(no);
		if(festival == null) {
			throw new BizNotFoundException("데이터 ["+no+"번 ] 조회 실패 ");
		}
		return festival;
	}
	
	@Override
	public List<FestivalVO> getFestivalList(PagingVO vo) throws BizException {
		int cnt = festivalDao.getFestivalCount(vo);
		vo.setTotalRowCount(cnt);
		vo.setting();
		List<FestivalVO> list = festivalDao.getFestivalList(vo);
		return list;
	}



}
