package com.proj.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.exception.BizAccessFailException;
import com.proj.exception.BizException;
import com.proj.exception.BizNotFoundException;
import com.proj.reply.dao.IReplyDao;
import com.proj.reply.vo.ReplySearchVO;
import com.proj.reply.vo.ReplyVO2;

@Service
public class ReplyServiceImpl implements IReplyService{
	
	@Autowired	//@Resource, @inject 써도됨
	private IReplyDao replyDao;
	
	@Override
	public List<ReplyVO2> getReplyListByParent(ReplySearchVO searchVO) throws BizException {
		int rowCount = replyDao.getReplyCountByParent(searchVO);
		searchVO.setTotalRowCount(rowCount);
		searchVO.setting();
		return replyDao.getReplyListByParent(searchVO);
	}

	@Override
	public void registReply(ReplyVO2 reply) throws BizException {
		replyDao.insertReply(reply);
	}

	@Override
	public void modifyReply(ReplyVO2 reply) throws BizException {
		ReplyVO2 vo = replyDao.getReply(reply.getReNo());
		if (vo == null) {
			throw new BizNotFoundException("글번호[" + reply.getReNo() + "]을 조회하지 못했습니다.");
		}
		if (!vo.getReMemId().equals(reply.getReMemId())) {
			throw new BizAccessFailException("해당 글의 작성자가 아닙니다.");
		}
		replyDao.updateReply(reply);
	}

	@Override
	public void removeReply(ReplyVO2 reply) throws BizException {
		ReplyVO2 vo = replyDao.getReply(reply.getReNo());
		if (!vo.getReMemId().equals(reply.getReMemId())) {
			throw new BizAccessFailException("해당 글의 작성자가 아닙니다.");
		}
		replyDao.deleteReply(reply);
		
		
	}

}
