package com.proj.cart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.cart.dao.ICartDao;
import com.proj.cart.vo.CartVO;
import com.proj.common.vo.AreaVO;
import com.proj.exception.BizException;

@Service
public class CartServiceImpl implements ICartService{
	
	@Autowired
	private ICartDao cartDao; // = new FreeBoardDaoOracle();

	
	@Override
	public List<AreaVO> getAreaCode(String memId) throws BizException {
		List<AreaVO> list = cartDao.getAreaCode(memId);
		return list;
	}
	
	@Override
	public int getCartCount(Map<String, Object> params) throws BizException {
		return cartDao.getCartCount(params);
	}
	
	@Override
	public List<CartVO> getCartList(Map<String, Object> params) throws BizException {
		List<CartVO> list = cartDao.getCartList(params);
		return list;
	}



	

	

}
