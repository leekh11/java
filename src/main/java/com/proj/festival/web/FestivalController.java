package com.proj.festival.web;

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
import com.proj.festival.service.IFestivalService;
import com.proj.festival.vo.FestivalVO;

@Controller
public class FestivalController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	IFestivalService festivalService;
	// 관리자용 매핑
	@RequestMapping("/festival/festivalList.mg")
	public ModelAndView festivalListMg(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<FestivalVO> list = festivalService.getFestivalList(vo);

		mav.addObject("festivalList", list);
		mav.setViewName("festival/festivalList");

		return mav;
	}
	
	// 메인화면 매핑
	@RequestMapping("/festival/festivalList.html")
	public ModelAndView festivalList(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<FestivalVO> list = festivalService.getFestivalList(vo);

		mav.addObject("festivalList", list);
		mav.setViewName("festival/festivalList");

		return mav;
	}
	

	@RequestMapping("/festival/festivalView.mg")
	public String festivalView(@RequestParam(name ="no", required = false, defaultValue = "1") int no, Model model) throws Exception {
		try {
			FestivalVO festival = festivalService.getFestival(no);

			model.addAttribute("festival", festival);

			return "festival/festivalView";

		} catch (BizNotFoundException e) {
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("조회 실패").setMessage("해당 페이지 정보를 찾지 못했습니다.!").setUrl("festivalList.mg")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/festival/festivalEdit.mg", method = RequestMethod.GET)
	public String festivalEdit(int no, Model model) throws Exception {
		try {
			FestivalVO festival = festivalService.getFestival(no);
			model.addAttribute("festival", festival);
			return "festival/festivalEdit";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage(), e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle(" 조회 실패").setMessage("해당 글이 존재하지 않거나 삭제 되었습니다").setUrl("festivalList.html")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/festival/festivalModify.mg", method = RequestMethod.POST)
	public String festivalModify(@ModelAttribute("festival") FestivalVO festival, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		festivalService.modifyFestival(festival);
		messageVO.setResult(true).setTitle("수정 성공").setMessage("수정 성공!").setUrl("festivalList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping("/festival/festivalForm.mg")
	public String festivalForm(Model model) throws Exception {

		model.addAttribute("festival", new FestivalVO());
		return "festival/festivalForm";
	}

	@RequestMapping("/festival/festivalRegist.mg")
	public String festivalRegist(@ModelAttribute("festival") FestivalVO festival, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		festivalService.registFestival(festival);
		messageVO.setResult(true).setTitle("등록 성공").setMessage("등록 성공!").setUrl("festivalList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping(value = "/festival/festivalRemove.mg", method = RequestMethod.POST)
	public String festivalRemove(@ModelAttribute("festival") FestivalVO festival, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		festivalService.removeFestival(festival);
		messageVO.setResult(true).setTitle("삭제 성공").setMessage("삭제 성공!").setUrl("festivalList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

}
