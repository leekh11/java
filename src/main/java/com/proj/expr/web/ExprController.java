package com.proj.expr.web;

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
import com.proj.expr.service.IExprService;
import com.proj.expr.vo.ExprVO;

@Controller
public class ExprController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	IExprService exprService;
	// 관리자용 매핑
	@RequestMapping("/expr/exprList.mg")
	public ModelAndView exprListMg(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<ExprVO> list = exprService.getExprList(vo);

		mav.addObject("exprList", list);
		mav.setViewName("expr/exprList");

		return mav;
	}
	
	// 메인화면 매핑
	@RequestMapping("/expr/exprList.html")
	public ModelAndView exprList(@ModelAttribute("vo") PagingVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<ExprVO> list = exprService.getExprList(vo);

		mav.addObject("exprList", list);
		mav.setViewName("expr/exprList");

		return mav;
	}
	

	@RequestMapping("/expr/exprView.mg")
	public String exprView(@RequestParam(name ="no", required = false, defaultValue = "1") int no, Model model) throws Exception {
		try {
			ExprVO expr = exprService.getExpr(no);
			ExprVO exprPre;
			ExprVO exprPost;
			if(no>1) {
			exprPre = exprService.getExpr(no-1);
			} else {
			exprPre = new ExprVO();
			exprPre.setName("이전글이 존재하지 않습니다.");
			}
			if(no < exprService.getExprMaxCount()) {
			exprPost = exprService.getExpr(no+1);				
			} else {
				exprPost = new ExprVO();
				exprPost.setName("글이 존재하지 않습니다.");
			}

			model.addAttribute("expr", expr);
			model.addAttribute("exprPre", exprPre);
			model.addAttribute("exprPost", exprPost);

			return "expr/exprView";

		} catch (BizNotFoundException e) {
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("조회 실패").setMessage("해당 페이지 정보를 찾지 못했습니다.!").setUrl("exprList.mg")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/expr/exprEdit.mg", method = RequestMethod.GET)
	public String exprEdit(int no, Model model) throws Exception {
		try {
			ExprVO expr = exprService.getExpr(no);
			model.addAttribute("expr", expr);
			return "expr/exprEdit";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage(), e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle(" 조회 실패").setMessage("해당 글이 존재하지 않거나 삭제 되었습니다").setUrl("exprList.html")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/expr/exprModify.mg", method = RequestMethod.POST)
	public String exprModify(@ModelAttribute("expr") ExprVO expr, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		exprService.modifyExpr(expr);
		messageVO.setResult(true).setTitle("수정 성공").setMessage("수정 성공!").setUrl("exprList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping("/expr/exprForm.mg")
	public String exprForm(Model model) throws Exception {

		model.addAttribute("expr", new ExprVO());
		return "expr/exprForm";
	}

	@RequestMapping("/expr/exprRegist.mg")
	public String exprRegist(@ModelAttribute("expr") ExprVO expr, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		exprService.registExpr(expr);
		messageVO.setResult(true).setTitle("등록 성공").setMessage("등록 성공!").setUrl("exprList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping(value = "/expr/exprRemove.mg", method = RequestMethod.POST)
	public String exprRemove(@ModelAttribute("expr") ExprVO expr, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		exprService.removeExpr(expr);
		messageVO.setResult(true).setTitle("삭제 성공").setMessage("삭제 성공!").setUrl("exprList.mg").setUrlTitle("목록으로");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}


	
	
}
