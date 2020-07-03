package com.proj.notice.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proj.common.vo.PagingVO;
import com.proj.common.vo.ResultMessageVO;
import com.proj.exception.BizNotFoundException;
import com.proj.notice.service.INoticeService;
import com.proj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	INoticeService noticeService;
	// 관리자용 매핑
	@RequestMapping("/notice/noticeList.mg")
	public ModelAndView noticeListMg(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<NoticeVO> list = noticeService.getNoticeList(vo);

		mav.addObject("noticeList", list);
		mav.setViewName("notice/noticeList");

		return mav;
	}
	
	// 메인화면 매핑
	@RequestMapping("/notice/noticeList.html")
	public ModelAndView noticeList(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<NoticeVO> list = noticeService.getNoticeList(vo);

		mav.addObject("noticeList", list);
		mav.setViewName("notice/noticeList");

		return mav;
	}
	

	@RequestMapping("/notice/noticeView.mg")
	public String noticeView(@RequestParam(name ="no", required = false, defaultValue = "1") int no, Model model) throws Exception {
		try {
			NoticeVO notice = noticeService.getNotice(no);

			model.addAttribute("notice", notice);

			return "notice/noticeView";

		} catch (BizNotFoundException e) {
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("조회 실패").setMessage("해당 페이지 정보를 찾지 못했습니다.!").setUrl("noticeList.mg")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/notice/noticeEdit.mg", method = RequestMethod.GET)
	public String noticeEdit(int no, Model model) throws Exception {
		try {
			NoticeVO notice = noticeService.getNotice(no);
			model.addAttribute("notice", notice);
			return "notice/noticeEdit";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage(), e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle(" 조회 실패").setMessage("해당 글이 존재하지 않거나 삭제 되었습니다").setUrl("noticeList.html")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/notice/noticeModify.mg", method = RequestMethod.POST)
	public String noticeModify(@ModelAttribute("notice") NoticeVO notice, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		noticeService.modifyNotice(notice);
		messageVO.setResult(true).setTitle("수정 성공").setMessage("수정 성공!").setUrl("noticeList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping("/notice/noticeForm.mg")
	public String NoticeForm(Model model) throws Exception {

		model.addAttribute("notice", new NoticeVO());
		return "notice/noticeForm";
	}

	@RequestMapping("/notice/noticeRegist.mg")
	public String noticeRegist(@ModelAttribute("notice") NoticeVO notice, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		noticeService.registNotice(notice);
		messageVO.setResult(true).setTitle("등록 성공").setMessage("등록 성공!").setUrl("noticeList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping(value = "/notice/noticeRemove.mg", method = RequestMethod.POST)
	public String noticeRemove(@ModelAttribute("notice") NoticeVO notice, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		noticeService.removeNotice(notice);
		messageVO.setResult(true).setTitle("삭제 성공").setMessage("삭제 성공!").setUrl("noticeList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

}
