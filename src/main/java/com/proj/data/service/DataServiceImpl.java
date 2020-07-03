package com.proj.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.common.vo.PagingVO;
import com.proj.data.dao.IDataDao;
import com.proj.data.vo.DataVO;
import com.proj.exception.BizException;

@Service
public class DataServiceImpl implements IDataService {

	@Autowired
	private IDataDao dataDao;

	@Override
	public void registData(DataVO notice) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyData(DataVO notice) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeData(DataVO notice) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DataVO getNotice(int no) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataVO> getNoticeList(PagingVO vo) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}



}
