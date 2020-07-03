package com.proj.food.web;

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
import com.proj.food.service.IFoodService;
import com.proj.food.vo.FoodVO;

@Controller
public class FoodController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	IFoodService foodService;
	// 관리자용 매핑
	@RequestMapping("/food/foodList.mg")
	public ModelAndView foodListMg(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<FoodVO> list = foodService.getFoodList(vo);

		mav.addObject("foodList", list);
		mav.setViewName("food/foodList");

		return mav;
	}
	
	// 메인화면 매핑
	@RequestMapping("/food/foodList.html")
	public ModelAndView foodList(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<FoodVO> list = foodService.getFoodList(vo);

		mav.addObject("foodList", list);
		mav.setViewName("food/foodList");

		return mav;
	}
	

	@RequestMapping("/food/foodView.mg")
	public String foodView(@RequestParam(name ="no", required = false, defaultValue = "1") int no, Model model) throws Exception {
		try {
			FoodVO food = foodService.getFood(no);

			model.addAttribute("food", food);

			return "food/foodView";

		} catch (BizNotFoundException e) {
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("조회 실패").setMessage("해당 페이지 정보를 찾지 못했습니다.!").setUrl("foodList.mg")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/food/foodEdit.mg", method = RequestMethod.GET)
	public String foodEdit(int no, Model model) throws Exception {
		try {
			FoodVO food = foodService.getFood(no);
			model.addAttribute("food", food);
			return "food/foodEdit";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage(), e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle(" 조회 실패").setMessage("해당 글이 존재하지 않거나 삭제 되었습니다").setUrl("foodList.html")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/food/foodModify.mg", method = RequestMethod.POST)
	public String foodModify(@ModelAttribute("food") FoodVO food, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		foodService.modifyFood(food);
		messageVO.setResult(true).setTitle("수정 성공").setMessage("수정 성공!").setUrl("foodList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping("/food/foodForm.mg")
	public String foodForm(Model model) throws Exception {

		model.addAttribute("food", new FoodVO());
		return "food/foodForm";
	}

	@RequestMapping("/food/foodRegist.mg")
	public String foodRegist(@ModelAttribute("food") FoodVO food, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		foodService.registFood(food);
		messageVO.setResult(true).setTitle("등록 성공").setMessage("등록 성공!").setUrl("foodList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping(value = "/food/foodRemove.mg", method = RequestMethod.POST)
	public String foodRemove(@ModelAttribute("food") FoodVO food, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		foodService.removeFood(food);
		messageVO.setResult(true).setTitle("삭제 성공").setMessage("삭제 성공!").setUrl("foodList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

}
