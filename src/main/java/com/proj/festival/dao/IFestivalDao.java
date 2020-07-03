package com.proj.festival.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.common.vo.PagingVO;
import com.proj.exception.DaoException;
import com.proj.festival.vo.FestivalVO;

@Mapper
public interface IFestivalDao {
	
	public int InsertFestival(FestivalVO festival) throws DaoException;
	public int updateFestival(FestivalVO festival) throws DaoException;
	public int deleteFestival(FestivalVO festival) throws DaoException;
	public FestivalVO getFestival(int no) throws DaoException;
	public List<FestivalVO> getFestivalList(PagingVO vo) throws DaoException;
	public int getFestivalCount(PagingVO vo) throws DaoException;
}
