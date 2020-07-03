package com.proj.stay.web;

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
import com.proj.stay.service.IStayService;
import com.proj.stay.vo.StayVO;

@Controller
public class StayController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	IStayService stayService;
	// 관리자용 매핑
	@RequestMapping("/stay/stayList.mg")
	public ModelAndView stayListMg(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<StayVO> list = stayService.getStayList(vo);

		mav.addObject("stayList", list);
		mav.setViewName("stay/stayList");

		return mav;
	}
	
	// 메인화면 매핑
	@RequestMapping("/stay/stayList.html")
	public ModelAndView stayList(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<StayVO> list = stayService.getStayList(vo);

		mav.addObject("stayList", list);
		mav.setViewName("stay/stayList");

		return mav;
	}
	

	@RequestMapping("/stay/stayView.mg")
	public String stayView(@RequestParam(name ="no", required = false, defaultValue = "1") int no, Model model) throws Exception {
		try {
			StayVO stay = stayService.getStay(no);

			model.addAttribute("stay", stay);

			return "stay/stayView";

		} catch (BizNotFoundException e) {
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("조회 실패").setMessage("해당 페이지 정보를 찾지 못했습니다.!").setUrl("stayList.mg")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/stay/stayEdit.mg", method = RequestMethod.GET)
	public String stayEdit(int no, Model model) throws Exception {
		try {
			StayVO stay = stayService.getStay(no);
			model.addAttribute("stay", stay);
			return "stay/stayEdit";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage(), e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle(" 조회 실패").setMessage("해당 글이 존재하지 않거나 삭제 되었습니다").setUrl("stayList.html")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/stay/stayModify.mg", method = RequestMethod.POST)
	public String stayModify(@ModelAttribute("stay") StayVO stay, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		stayService.modifyStay(stay);
		messageVO.setResult(true).setTitle("수정 성공").setMessage("수정 성공!").setUrl("stayList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping("/stay/stayForm.mg")
	public String stayForm(Model model) throws Exception {

		model.addAttribute("stay", new StayVO());
		return "stay/stayForm";
	}

	@RequestMapping("/stay/stayRegist.mg")
	public String stayRegist(@ModelAttribute("stay") StayVO stay, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		stayService.registStay(stay);
		messageVO.setResult(true).setTitle("등록 성공").setMessage("등록 성공!").setUrl("stayList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping(value = "/stay/stayRemove.mg", method = RequestMethod.POST)
	public String stayRemove(@ModelAttribute("stay") StayVO stay, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		stayService.removeStay(stay);
		messageVO.setResult(true).setTitle("삭제 성공").setMessage("삭제 성공!").setUrl("stayList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

}
