package com.proj.stay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.exception.BizNotEffectedException;
import com.proj.exception.BizNotFoundException;
import com.proj.stay.dao.IStayDao;
import com.proj.stay.vo.StayVO;

@Service
public class StayServiceImpl implements IStayService {

	@Autowired
	private IStayDao stayDao;

	@Override
	public void registStay(StayVO stay) throws BizException {
		try {
		int cnt = stayDao.InsertStay(stay);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", stay);
		}
		}catch (DuplicateKeyException e) {
			throw new DuplicateKeyException(e.getMessage(), e);
		}
	}

	@Override
	public void modifyStay(StayVO stay) throws BizException {
		int cnt = stayDao.updateStay(stay);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", stay);
		}		
	}

	@Override
	public void removeStay(StayVO stay) throws BizException {
		stayDao.deleteStay(stay);		
	}

	@Override
	public StayVO getStay(int no) throws BizException {
		StayVO stay = stayDao.getStay(no);
		if(stay == null) {
			throw new BizNotFoundException("데이터 ["+no+"번 ] 조회 실패 ");
		}
		return stay;
	}
	
	@Override
	public List<StayVO> getStayList(PagingVO vo) throws BizException {
		int cnt = stayDao.getStayCount(vo);
		vo.setTotalRowCount(cnt);
		vo.setting();
		List<StayVO> list = stayDao.getStayList(vo);
		return list;
	}



}
