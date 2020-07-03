package com.proj.expr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.common.vo.PagingVO;
import com.proj.exception.DaoException;
import com.proj.expr.vo.ExprVO;

@Mapper
public interface IExprDao {
	
	public int InsertExpr(ExprVO expr) throws DaoException;
	public int updateExpr(ExprVO expr) throws DaoException;
	public int deleteExpr(ExprVO expr) throws DaoException;
	public ExprVO getExpr(int no) throws DaoException;
	public List<ExprVO> getExprList(PagingVO vo) throws DaoException;
	public int getExprCount(PagingVO vo) throws DaoException;
	public int getExprMaxCount() throws DaoException;
}
