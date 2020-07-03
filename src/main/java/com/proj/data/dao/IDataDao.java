package com.proj.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.common.vo.PagingVO;
import com.proj.data.vo.DataVO;
import com.proj.exception.DaoException;
import com.proj.expr.vo.ExprVO;

@Mapper
public interface IDataDao {
	
	public int InsertE(ExprVO expr) throws DaoException;
	public int updateData(ExprVO expr) throws DaoException;
	public int deleteData(ExprVO expr) throws DaoException;
	public DataVO getData(int no) throws DaoException;
	public List<DataVO> getDataList(ExprVO vo) throws DaoException;
	public int getDataCount(PagingVO vo) throws DaoException;
}
