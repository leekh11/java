package com.proj.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.common.vo.PagingVO;
import com.proj.exception.DaoException;
import com.proj.notice.vo.NoticeVO;

@Mapper
public interface INoticeDao {
	
	public int InsertNotice(NoticeVO notice) throws DaoException;
	public int updateNotice(NoticeVO notice) throws DaoException;
	public int deleteNotice(NoticeVO notice) throws DaoException;
	public NoticeVO getNotice(int no) throws DaoException;
	public List<NoticeVO> getNoticeList(PagingVO vo) throws DaoException;
	public int getNoticeCount(PagingVO vo) throws DaoException;
}
