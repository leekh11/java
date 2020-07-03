package com.proj.stay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.common.vo.PagingVO;
import com.proj.exception.DaoException;
import com.proj.stay.vo.StayVO;

@Mapper
public interface IStayDao {
	
	public int InsertStay(StayVO stay) throws DaoException;
	public int updateStay(StayVO stay) throws DaoException;
	public int deleteStay(StayVO stay) throws DaoException;
	public StayVO getStay(int no) throws DaoException;
	public List<StayVO> getStayList(PagingVO vo) throws DaoException;
	public int getStayCount(PagingVO vo) throws DaoException;
}
