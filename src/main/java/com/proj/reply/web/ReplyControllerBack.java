package com.proj.reply.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proj.exception.BizAccessFailException;
import com.proj.exception.BizNotFoundException;
import com.proj.login.vo.UserVO;
import com.proj.reply.service.IReplyService;
import com.proj.reply.vo.ReplySearchVO;
import com.proj.reply.vo.ReplyVO2;

//@Controller

public class ReplyControllerBack {
	
	
	@Autowired
	private IReplyService replyService;
	
	
	@RequestMapping(value = "/reply/replyList", produces = "application/json;charset=UTF-8")
   @ResponseBody
	public Map<String, Object> replyList(ReplySearchVO searchVO) throws Exception {
		List<ReplyVO2> list = replyService.getReplyListByParent(searchVO);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		map.put("data", list);
		map.put("count", list.size());
		return map;
	}

	@RequestMapping(value = "/reply/replyRegist", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> replyRegist(ReplyVO2 reply, HttpServletRequest req, HttpSession session)
			throws Exception {
		UserVO user = (UserVO) session.getAttribute("USER_INFO");
		reply.setReMemId(user.getUserId());
		replyService.registReply(reply);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		map.put("msg", "정상 등록 되었습니다.");
		return map;
	}

	@RequestMapping(value = "/reply/replyModify")
    @ResponseBody
	public Map<String, Object> replyModify(ReplyVO2 reply, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("USER_INFO");
		reply.setReMemId(user.getUserId());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			replyService.modifyReply(reply);
			map.put("result", true);
			map.put("msg", "수정 되었습니다.");
			return map;
		} catch (BizNotFoundException e) {
			map.put("result", false);
			map.put("msg", "글이 존재하지 않습니다.");
			return map;
		} catch (BizAccessFailException e) {
			map.put("result", false);
			map.put("msg", "접근에 실패했습니다.");
			return map;
		}
	}
	
	
	
	@RequestMapping(value = "/reply/replyRemove")
    @ResponseBody
	public Map<String, Object> replyRemove(ReplyVO2 reply, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("USER_INFO");
		reply.setReMemId(user.getUserId());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			replyService.removeReply(reply);
			map.put("result", true);
			map.put("msg", "삭제 되었습니다.");
			return map;
		} catch (BizNotFoundException e) {
			map.put("result", false);
			map.put("msg", "글이 존재하지 않습니다.");
			return map;
		} catch (BizAccessFailException e) {
			map.put("result", false);
			map.put("msg", "접근에 실패했습니다.");
			return map;
		}
	}
		
}