package com.proj.place.web;

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
import com.proj.place.service.IPlaceService;
import com.proj.place.vo.PlaceVO;

@Controller
public class PlaceController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	IPlaceService placeService;
	// 관리자용 매핑
	@RequestMapping("/place/placeList.mg")
	public ModelAndView placeListMg(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<PlaceVO> list = placeService.getPlaceList(vo);

		mav.addObject("placeList", list);
		mav.setViewName("place/placeList");

		return mav;
	}
	
	// 메인화면 매핑
	@RequestMapping("/place/placeList.html")
	public ModelAndView placeList(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<PlaceVO> list = placeService.getPlaceList(vo);

		mav.addObject("placeList", list);
		mav.setViewName("place/placeList");

		return mav;
	}
	

	@RequestMapping("/place/placeView.mg")
	public String placeView(@RequestParam(name ="no", required = false, defaultValue = "1") int no, Model model) throws Exception {
		try {
			PlaceVO place = placeService.getPlace(no);

			model.addAttribute("place", place);

			return "place/placeView";

		} catch (BizNotFoundException e) {
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("조회 실패").setMessage("해당 페이지 정보를 찾지 못했습니다.!").setUrl("placeList.mg")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/place/placeEdit.mg", method = RequestMethod.GET)
	public String placeEdit(int no, Model model) throws Exception {
		try {
			PlaceVO place = placeService.getPlace(no);
			model.addAttribute("place", place);
			return "place/placeEdit";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage(), e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle(" 조회 실패").setMessage("해당 글이 존재하지 않거나 삭제 되었습니다").setUrl("placeList.html")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/place/placeModify.mg", method = RequestMethod.POST)
	public String placeModify(@ModelAttribute("place") PlaceVO place, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		placeService.modifyPlace(place);
		messageVO.setResult(true).setTitle("수정 성공").setMessage("수정 성공!").setUrl("placeList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping("/place/placeForm.mg")
	public String placeForm(Model model) throws Exception {

		model.addAttribute("place", new PlaceVO());
		return "place/placeForm";
	}

	@RequestMapping("/place/placeRegist.mg")
	public String placeRegist(@ModelAttribute("place") PlaceVO place, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		placeService.registPlace(place);
		messageVO.setResult(true).setTitle("등록 성공").setMessage("등록 성공!").setUrl("placeList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping(value = "/place/placeRemove.mg", method = RequestMethod.POST)
	public String placeRemove(@ModelAttribute("place") PlaceVO place, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		placeService.removePlace(place);
		messageVO.setResult(true).setTitle("삭제 성공").setMessage("삭제 성공!").setUrl("placeList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

}
