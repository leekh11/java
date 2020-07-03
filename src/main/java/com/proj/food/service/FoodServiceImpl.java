package com.proj.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.exception.BizNotEffectedException;
import com.proj.exception.BizNotFoundException;
import com.proj.food.dao.IFoodDao;
import com.proj.food.vo.FoodVO;

@Service
public class FoodServiceImpl implements IFoodService {

	@Autowired
	private IFoodDao foodDao;

	@Override
	public void registFood(FoodVO food) throws BizException {
		try {
		int cnt = foodDao.InsertFood(food);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", food);
		}
		}catch (DuplicateKeyException e) {
			throw new DuplicateKeyException(e.getMessage(), e);
		}
	}

	@Override
	public void modifyFood(FoodVO food) throws BizException {
		int cnt = foodDao.updateFood(food);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", food);
		}		
	}

	@Override
	public void removeFood(FoodVO food) throws BizException {
		foodDao.deleteFood(food);		
	}

	@Override
	public FoodVO getFood(int no) throws BizException {
		FoodVO food = foodDao.getFood(no);
		if(food == null) {
			throw new BizNotFoundException("데이터 ["+no+"번 ] 조회 실패 ");
		}
		return food;
	}
	
	@Override
	public List<FoodVO> getFoodList(PagingVO vo) throws BizException {
		int cnt = foodDao.getFoodCount(vo);
		vo.setTotalRowCount(cnt);
		vo.setting();
		List<FoodVO> list = foodDao.getFoodList(vo);
		return list;
	}



}
