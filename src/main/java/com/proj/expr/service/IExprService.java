package com.proj.expr.service;

import java.util.List;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.exception.DaoException;
import com.proj.expr.vo.ExprVO;

public interface IExprService {
	public void registExpr(ExprVO expr) throws BizException;
	public void modifyExpr(ExprVO expr) throws BizException;
	public void removeExpr(ExprVO expr) throws BizException;
	public ExprVO getExpr(int no) throws BizException;
	public List<ExprVO> getExprList(PagingVO vo) throws BizException;
	public int getExprMaxCount() throws DaoException;

}
