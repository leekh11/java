package com.proj.place.service;

import java.util.List;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.place.vo.PlaceVO;

public interface IPlaceService {
	public void registPlace(PlaceVO place) throws BizException;
	public void modifyPlace(PlaceVO place) throws BizException;
	public void removePlace(PlaceVO place) throws BizException;
	public PlaceVO getPlace(int no) throws BizException;
	public List<PlaceVO> getPlaceList(PagingVO vo) throws BizException;

}
