package com.proj.reply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.reply.vo.ReplySearchVO;
import com.proj.reply.vo.ReplyVO2;

@Mapper
public interface IReplyDao {
	
	public int getReplyCountByParent(ReplySearchVO searchVO);
	public List<ReplyVO2> getReplyListByParent(ReplySearchVO searchVO);
	public ReplyVO2 getReply(int reNo);
	public int insertReply(ReplyVO2 reply);
	public int updateReply(ReplyVO2 reply);
	public int deleteReply(ReplyVO2 reply);

}
