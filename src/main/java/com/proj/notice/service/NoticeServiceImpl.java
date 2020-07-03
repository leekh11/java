package com.proj.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.proj.common.vo.PagingVO;
import com.proj.exception.BizNotEffectedException;
import com.proj.exception.BizNotFoundException;
import com.proj.notice.dao.INoticeDao;
import com.proj.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements INoticeService {

	@Autowired
	private INoticeDao noticeDao;
	
	@Override
	public void registNotice(NoticeVO notice) {
		try {
		int cnt = noticeDao.InsertNotice(notice);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", notice);
		}
		}catch (DuplicateKeyException e) {
			throw new DuplicateKeyException(e.getMessage(), e);
		}
	}

	@Override
	public void modifyNotice(NoticeVO notice) {
		int cnt = noticeDao.updateNotice(notice);
		if (cnt < 1) {
			throw new BizNotEffectedException("등록이 되지 않았습니다.", notice);
		}
	}

	@Override
	public void removeNotice(NoticeVO notice) {
		noticeDao.deleteNotice(notice);
	}

	@Override
	public NoticeVO getNotice(int no) {
		NoticeVO notice = noticeDao.getNotice(no);
		if(notice == null) {
			throw new BizNotFoundException("공지 ["+no+"번 ] 조회 실패 ");
		}
		return notice;
	}

	@Override
	public List<NoticeVO> getNoticeList(PagingVO vo) {
		int cnt = noticeDao.getNoticeCount(vo);
		vo.setTotalRowCount(cnt);
		vo.setting();
		List<NoticeVO> list = noticeDao.getNoticeList(vo);
		return list;
	}

}
