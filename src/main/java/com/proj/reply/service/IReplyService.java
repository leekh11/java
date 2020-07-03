package com.proj.reply.service;

import java.util.List;

import com.proj.exception.BizException;
import com.proj.reply.vo.ReplySearchVO;
import com.proj.reply.vo.ReplyVO2;

public interface IReplyService {
	
	/**
	 * 댓글 목록 조회 <br>
	 * <b>필수 : reCategory, reParentNo </b>
	 */
	public List<ReplyVO2> getReplyListByParent(ReplySearchVO searchVO) throws BizException;

	/** 댓글등록 */
	public void registReply(ReplyVO2 reply) throws BizException;

	/**
	 * 댓글 수정 <br>
	 * 댓글이 존재하지 않으면 BizNotFoundException 
	 * 댓글 작성자와 로그인 사용자가 다른 경우
	 * BizAccessFailException
	 */
	public void modifyReply(ReplyVO2 reply) throws BizException;

	/**
	 * 댓글 삭제 <br>
	 * 해당글의 존재하지 않으면 BizNotFoundException 
	 * 댓글 작성자와 로그인 사용자가 다른 경우
	 * BizAccessFailException
	 */
	public void removeReply(ReplyVO2 reply) throws BizException;

}
