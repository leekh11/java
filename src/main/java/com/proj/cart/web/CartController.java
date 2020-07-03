package com.proj.cart.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proj.cart.service.ICartService;
import com.proj.cart.vo.CartVO;
import com.proj.common.vo.AreaVO;
import com.proj.common.vo.ResultMessageVO;
import com.proj.exception.BizPasswordNotMatchedException;
import com.proj.login.vo.UserVO;

@Controller
public class CartController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass()); 

	@Autowired
	private ICartService cartService;

	
	@RequestMapping("/cart/cart.html")
	public ModelAndView cartList(@RequestParam(name = "areaCode" , required = false) String areaCode
			                    , HttpSession session) throws Exception {
		logger.debug("cartList 진입");
		UserVO vo = (UserVO) session.getAttribute("USER_INFO");
		String memId = vo.getUserId();
		ModelAndView mav = new ModelAndView();
		//파라미터 두개를 넘겨야 해서 Map으로 묶어줌
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("memId", memId );
		paramMap.put("areaCode", areaCode );
		
		List<CartVO> cartlist = cartService.getCartList(paramMap);
		List<AreaVO> arealist = cartService.getAreaCode(memId);
		int count = cartService.getCartCount(paramMap);

		mav.addObject("cartList", cartlist);
		mav.addObject("areaList", arealist);
		mav.addObject("count", count);
		mav.setViewName("cart/cart");
		return mav;
	}//list
	
	

	@RequestMapping("index.html")
	public String home() throws Exception {
		return "home";
	}//list
	
	@RequestMapping("packages.html")
	public String about() throws Exception {
		return "recommand";
	}//list
	
	@RequestMapping("submarine.html")
	public String submarine() throws Exception {
		return "etc/submarine";
	}//list
	
}//class
