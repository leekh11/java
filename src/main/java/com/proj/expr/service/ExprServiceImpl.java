package com.proj.expr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.exception.BizNotEffectedException;
import com.proj.exception.BizNotFoundException;
import com.proj.exception.DaoException;
import com.proj.expr.dao.IExprDao;
import com.proj.expr.vo.ExprVO;

@Service
public class ExprServiceImpl implements IExprService {

	@Autowired
	private IExprDao exprDao;

	@Override
	public void registExpr(ExprVO expr) throws BizException {
		try {
		int cnt = exprDao.InsertExpr(expr);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", expr);
		}
		}catch (DuplicateKeyException e) {
			throw new DuplicateKeyException(e.getMessage(), e);
		}
	}

	@Override
	public void modifyExpr(ExprVO expr) throws BizException {
		int cnt = exprDao.updateExpr(expr);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", expr);
		}		
	}

	@Override
	public void removeExpr(ExprVO expr) throws BizException {
		exprDao.deleteExpr(expr);		
	}

	@Override
	public ExprVO getExpr(int no) throws BizException {
		ExprVO expr = exprDao.getExpr(no);
		if(expr == null) {
			throw new BizNotFoundException("데이터 ["+no+"번 ] 조회 실패 ");
		}
		return expr;
	}

	
	@Override
	public List<ExprVO> getExprList(PagingVO vo) throws BizException {
		int cnt = exprDao.getExprCount(vo);
		vo.setTotalRowCount(cnt);
		vo.setting();
		List<ExprVO> list = exprDao.getExprList(vo);
		return list;
	}

	@Override
	public int getExprMaxCount() throws DaoException {
		int cnt = exprDao.getExprMaxCount();
		return cnt;
	}



}
