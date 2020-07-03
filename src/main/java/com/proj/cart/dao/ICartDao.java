package com.proj.cart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.proj.cart.vo.CartVO;
import com.proj.common.vo.AreaVO;
import com.proj.exception.DaoException;

@Mapper
public interface ICartDao {
	
	public List<AreaVO> getAreaCode(String memId) throws DaoException;
	public int getCartCount(Map params) throws DaoException;
	public List<CartVO> getCartList(Map params) throws DaoException;	
}
