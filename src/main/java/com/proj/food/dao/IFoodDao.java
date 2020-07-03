package com.proj.food.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.common.vo.PagingVO;
import com.proj.exception.DaoException;
import com.proj.food.vo.FoodVO;

@Mapper
public interface IFoodDao {
	
	public int InsertFood(FoodVO Food) throws DaoException;
	public int updateFood(FoodVO Food) throws DaoException;
	public int deleteFood(FoodVO Food) throws DaoException;
	public FoodVO getFood(int no) throws DaoException;
	public List<FoodVO> getFoodList(PagingVO vo) throws DaoException;
	public int getFoodCount(PagingVO vo) throws DaoException;
}
