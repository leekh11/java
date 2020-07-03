package com.proj.place.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.exception.BizNotEffectedException;
import com.proj.exception.BizNotFoundException;
import com.proj.place.dao.IPlaceDao;
import com.proj.place.vo.PlaceVO;

@Service
public class PlaceServiceImpl implements IPlaceService {

	@Autowired
	private IPlaceDao placeDao;

	@Override
	public void registPlace(PlaceVO place) throws BizException {
		try {
		int cnt = placeDao.InsertPlace(place);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", place);
		}
		}catch (DuplicateKeyException e) {
			throw new DuplicateKeyException(e.getMessage(), e);
		}
	}

	@Override
	public void modifyPlace(PlaceVO place) throws BizException {
		int cnt = placeDao.updatePlace(place);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", place);
		}		
	}

	@Override
	public void removePlace(PlaceVO place) throws BizException {
		placeDao.deletePlace(place);		
	}

	@Override
	public PlaceVO getPlace(int no) throws BizException {
		PlaceVO place = placeDao.getPlace(no);
		if(place == null) {
			throw new BizNotFoundException("데이터 ["+no+"번 ] 조회 실패 ");
		}
		return place;
	}
	
	@Override
	public List<PlaceVO> getPlaceList(PagingVO vo) throws BizException {
		int cnt = placeDao.getPlaceCount(vo);
		vo.setTotalRowCount(cnt);
		vo.setting();
		List<PlaceVO> list = placeDao.getPlaceList(vo);
		return list;
	}



}
