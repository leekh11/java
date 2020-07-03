package com.proj.data.service;

import java.util.List;

import com.proj.common.vo.PagingVO;
import com.proj.data.vo.DataVO;
import com.proj.exception.BizException;

public interface IDataService {
	public void registData(DataVO notice) throws BizException;
	public void modifyData(DataVO notice) throws BizException;
	public void removeData(DataVO notice) throws BizException;
	public DataVO getNotice(int no) throws BizException;
	public List<DataVO> getNoticeList(PagingVO vo) throws BizException;

}
