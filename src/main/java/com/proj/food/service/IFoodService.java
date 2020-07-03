package com.proj.food.service;

import java.util.List;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.food.vo.FoodVO;

public interface IFoodService {
	public void registFood(FoodVO food) throws BizException;
	public void modifyFood(FoodVO food) throws BizException;
	public void removeFood(FoodVO food) throws BizException;
	public FoodVO getFood(int no) throws BizException;
	public List<FoodVO> getFoodList(PagingVO vo) throws BizException;

}
