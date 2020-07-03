package com.proj.place.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.common.vo.PagingVO;
import com.proj.exception.DaoException;
import com.proj.place.vo.PlaceVO;

@Mapper
public interface IPlaceDao {
	
	public int InsertPlace(PlaceVO place) throws DaoException;
	public int updatePlace(PlaceVO place) throws DaoException;
	public int deletePlace(PlaceVO place) throws DaoException;
	public PlaceVO getPlace(int no) throws DaoException;
	public List<PlaceVO> getPlaceList(PagingVO vo) throws DaoException;
	public int getPlaceCount(PagingVO vo) throws DaoException;
}
