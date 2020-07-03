package com.proj.cart.service;

import java.util.List;
import java.util.Map;

import com.proj.cart.vo.CartVO;
import com.proj.common.vo.AreaVO;
import com.proj.exception.BizException;

public interface ICartService {
	
	public List<AreaVO> getAreaCode(String memId) throws BizException;
	public int getCartCount(Map<String, Object> params) throws BizException;
	public List<CartVO> getCartList(Map<String, Object> params) throws BizException;
	

}
