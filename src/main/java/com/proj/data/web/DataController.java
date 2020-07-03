package com.proj.data.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proj.common.vo.PagingVO;
import com.proj.expr.service.IExprService;
import com.proj.expr.vo.ExprVO;
import com.proj.festival.service.IFestivalService;
import com.proj.festival.vo.FestivalVO;
import com.proj.food.service.IFoodService;
import com.proj.food.vo.FoodVO;
import com.proj.place.service.IPlaceService;
import com.proj.place.vo.PlaceVO;
import com.proj.stay.service.IStayService;
import com.proj.stay.vo.StayVO;

@Controller
public class DataController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	IFestivalService festivalService;
	@Autowired
	IFoodService foodService;
	@Autowired
	IExprService exprService;
	@Autowired
	IPlaceService placeService;
	@Autowired
	IStayService stayService;
	
	@RequestMapping("/data/dataList.mg")
	public ModelAndView dataList(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();
		vo.setRowSizePerPage(5);
		vo.setPageSize(3);
		vo.setCurPage(1);
		List<FestivalVO> list = festivalService.getFestivalList(vo);
		List<FoodVO> list2 = foodService.getFoodList(vo);
		List<ExprVO> list3 = exprService.getExprList(vo);
		List<PlaceVO> list4 = placeService.getPlaceList(vo);
		List<StayVO> list5 = stayService.getStayList(vo);
		
		mav.addObject("festivalList", list);
		mav.addObject("foodList", list2);
		mav.addObject("exprList", list3);
		mav.addObject("placeList", list4);
		mav.addObject("stayList", list5);
		
		mav.setViewName("data/dataList");

		return mav;
	}
	@RequestMapping("/data/dataListM.mg")
	public String dataListN() throws Exception {
		return "data/dataListM";
	}
	
}
