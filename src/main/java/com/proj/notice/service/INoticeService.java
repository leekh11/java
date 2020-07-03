package com.proj.notice.service;

import java.util.List;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizException;
import com.proj.notice.vo.NoticeVO;

public interface INoticeService {
	public void registNotice(NoticeVO notice) throws BizException;
	public void modifyNotice(NoticeVO notice) throws BizException;
	public void removeNotice(NoticeVO notice) throws BizException;
	public NoticeVO getNotice(int no) throws BizException;
	public List<NoticeVO> getNoticeList(PagingVO vo) throws BizException;

}
