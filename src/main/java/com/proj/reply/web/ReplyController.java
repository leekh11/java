package com.proj.reply.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.exception.BizAccessFailException;
import com.proj.exception.BizNotFoundException;
import com.proj.login.vo.UserVO;
import com.proj.reply.service.IReplyService;
import com.proj.reply.vo.ReplySearchVO;
import com.proj.reply.vo.ReplyVO2;

@RestController
public class ReplyController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IReplyService replyService;
	
	
	@RequestMapping(value = "/reply/replyList", produces = "application/json;charset=UTF-8")
	public Map<String, Object> replyList(ReplySearchVO searchVO) throws Exception {
		logger.debug("searchVO={}", searchVO);
		List<ReplyVO2> list = replyService.getReplyListByParent(searchVO);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		map.put("data", list);
		map.put("count", list.size());
		return map;
	}

	@PostMapping("/reply/replyRegist")
	public Map<String, Object> replyRegist(ReplyVO2 reply, HttpServletRequest req, HttpSession session)
			throws Exception {
		logger.debug("reply={}", reply);
		UserVO user = (UserVO) session.getAttribute("USER_INFO");
		reply.setReMemId(user.getUserId());
		replyService.registReply(reply);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		map.put("msg", "정상 등록 되었습니다.");
		return map;
	}

	@RequestMapping(value = "/reply/replyModify")
	public Map<String, Object> replyModify(ReplyVO2 reply, HttpSession session) throws Exception {
		logger.debug("reply={}", reply);	//로거 해야좋음
		UserVO user = (UserVO) session.getAttribute("USER_INFO");
		reply.setReMemId(user.getUserId());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			replyService.modifyReply(reply);
			map.put("result", true);
			map.put("msg", "수정 되었습니다.");
			return map;
		} catch (BizNotFoundException e) {
			logger.warn("msg={}, reply={}", e.getMessage(), reply, e);
			map.put("result", false);
			map.put("msg", "글이 존재하지 않습니다.");
			return map;
		} catch (BizAccessFailException e) {
			logger.warn("msg={}, reply={}", e.getMessage(), reply, e);
			map.put("result", false);
			map.put("msg", "접근에 실패했습니다.");
			return map;
		}
	}
	
	
	
	@RequestMapping(value = "/reply/replyRemove")
	public Map<String, Object> replyRemove(ReplyVO2 reply, HttpSession session) throws Exception {
		logger.debug("reply={}", reply);
		UserVO user = (UserVO) session.getAttribute("USER_INFO");
		reply.setReMemId(user.getUserId());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			replyService.removeReply(reply);
			map.put("result", true);
			map.put("msg", "삭제 되었습니다.");
			return map;
		} catch (BizNotFoundException e) {
			logger.warn("msg={}, reply={}", e.getMessage(), reply, e);
			map.put("result", false);
			map.put("msg", "글이 존재하지 않습니다.");
			return map;
		} catch (BizAccessFailException e) {
			logger.warn("msg={}, reply={}", e.getMessage(), reply, e);
			map.put("result", false);
			map.put("msg", e.getMessage());
			return map;
		}
	}
		
}
