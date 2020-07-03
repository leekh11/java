package com.proj.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proj.board.service.IBoardService;
import com.proj.board.vo.BoardSearchVO;
import com.proj.board.vo.BoardVO;
import com.proj.code.service.ICommonCodeService;
import com.proj.code.vo.CodeVO;
import com.proj.common.vo.ResultMessageVO;
import com.proj.exception.BizDuplicateException;
import com.proj.exception.BizNotEffectedException;
import com.proj.exception.BizNotFoundException;
import com.proj.exception.BizPasswordNotMatchedException;
//<<<<<<< .mine
//=======
import com.proj.login.vo.UserVO;
//>>>>>>> .r37

@Controller
@RequestMapping("/board")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IBoardService boardService;
	@Autowired
	private ICommonCodeService codeService;

	@ModelAttribute("themeList")
	public List<CodeVO> themeData() {
		logger.debug("themeList 처리");
		List<CodeVO> codeList = codeService.getCodeListByParent("TM00");
		return codeList;
	}

	@ModelAttribute("areaList")
	public List<CodeVO> areaData() {
		logger.debug("areaList 처리");
		List<CodeVO> codeList = codeService.getCodeListByParent("AR00");
		return codeList;
	}

	// ModelAndView 에 모델정보와 뷰이름을 담고 리턴
	// parameter에 커멘드객체(VO) 를 사용하면 요청파라미터 바인딩, 모델에 저장
	// Model에 저장되는 이름이 클래스이름(첫글자 소문자)

	@RequestMapping("/boardList.html")
	public ModelAndView boardList(@ModelAttribute("boardVO") BoardSearchVO searchVO) throws Exception {

		ModelAndView mav = new ModelAndView();

		List<BoardVO> list = boardService.getBoardList(searchVO);

		// 과정4. 모델로부터 전달받은 결과물을 속성에 저장
		mav.addObject("boardList", list);
		mav.setViewName("board/boardList");

		return mav;

	}

	@RequestMapping("/boardListM.mg")
	public ModelAndView boardListM(@ModelAttribute("boardVO") BoardSearchVO searchVO) throws Exception {

		ModelAndView mav = new ModelAndView();

		List<BoardVO> list = boardService.getBoardList(searchVO);

		// 과정4. 모델로부터 전달받은 결과물을 속성에 저장
		mav.addObject("boardList", list);
		mav.setViewName("board/boardListM");

		return mav;

	}

	@RequestMapping("/boardView.html")
	public String boardView(@RequestParam("boNum") int boNum, Model model) throws Exception {

		try {
			BoardVO board = boardService.getBoard(boNum);
			System.out.println(board);
			if (board != null) { // 조회수증가
				boardService.increaseHit(boNum);
			}
			// 과정4. 모델로부터 전달받은 결과물을 속성에 저장
			model.addAttribute("board", board);

			return "board/boardView";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage(), e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("게시판 조회 실패").setMessage("해당게시물이 존재하지않거나, 삭제되었습니다.").setUrl("boardList.html")
					.setUrlTitle("목록으로");

			model.addAttribute("messageVO", vo);

			return "common/message";
		}
	}

	@RequestMapping(value = "/boardEdit.html", method = RequestMethod.GET) // get방식만 받을거야
	public String boardEdit(int boNum, Model model) throws Exception {
		logger.debug("boNum = {}", boNum);
		try { // try catch: alt shift z
			BoardVO board = boardService.getBoard(boNum);
			// 과정4. 모델로부터 전달받은 결과물을 속성에 저장
			model.addAttribute("board", board);
			return "board/boardEdit";

		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage(), e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("게시판 조회 실패").setMessage("해당게시물이 존재하지않거나, 삭제되었습니다.").setUrl("boardList.html")
					.setUrlTitle("목록으로");

			model.addAttribute("messageVO", vo);

			return "common/message";
		}
	}

	@RequestMapping(value = "/boardModify.html", method = RequestMethod.POST)
	public String boardModify(@ModelAttribute("board") @Valid BoardVO Board, BindingResult errors // 포인트
			, HttpServletRequest req, Model model) throws Exception {

		ResultMessageVO messageVO = new ResultMessageVO();

		try {
			// 검증
			if (errors.hasErrors()) {
//					model.addAttribute("board", Board);
				return "board/boardEdit";
			}

			boardService.modifyBoard(Board);

			messageVO.setResult(true).setTitle("게시판 수정 성공").setMessage("게시판의 정보를 수정하였습니다.").setUrl("boardList.html")
					.setUrlTitle("목록으로");

			// BNotFoundE, BizPasswordNotMatchedException, BizNotEffectedException
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 조회 실패").setMessage("해당 게시물이 존재하지 않습니다.").setUrl("boardList.html")
					.setUrlTitle("목록으로");

		} catch (BizPasswordNotMatchedException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 수정 실패").setMessage("비밀번호를 확인하여 주세요.");

		} catch (BizNotEffectedException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 수정 실패").setMessage("해당 게시물의 정보를 변경하지 못했습니다.")
					.setUrl("boardList.html").setUrlTitle("목록으로");

		}

		model.addAttribute("messageVO", messageVO);
		return "common/message";

	}

	@RequestMapping(value = "/boardForm.html")
	public String boardForm(Model model, HttpSession session) throws Exception {
		BoardVO vo = new BoardVO();
		String id = "";
		if (session.getAttribute("USER_INFO") == null) {
			id = "익명";
		} else {
			id = ((UserVO) session.getAttribute("USER_INFO")).getUserId();
		}
		vo.setBoId(id);
		model.addAttribute("board", vo);

		return "board/boardForm";
	}

	@RequestMapping(value = "/boardRegist.html", method = RequestMethod.POST)
	public String boardRegist(@ModelAttribute("board") @Valid BoardVO Board, BindingResult errors, Model model)
			throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		try {
			if (errors.hasErrors()) {
				return "board/boardForm";
			}
			boardService.registBoard(Board);
			messageVO.setResult(true).setTitle("새글쓰기 성공").setMessage("새글쓰기 성공!").setUrl("boardList.html")
					.setUrlTitle("목록으로");
		} catch (BizDuplicateException e) {
			logger.warn(e.getMessage(), e);
			messageVO.setResult(false).setTitle("새글쓰기 실패").setMessage("해당 제목 사용중입니다.!").setUrl("boardList.html")
					.setUrlTitle("목록으로");
		}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping(value = "/boardDelete.html", method = RequestMethod.POST)
	public String boardDelete(BoardVO Board, HttpServletRequest req, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		try {
			boardService.removeBoard(Board);

			messageVO.setResult(true).setTitle("게시판 삭제 성공").setMessage("게시판의 정보를 삭제하였습니다.").setUrl("boardList.html")
					.setUrlTitle("목록으로");
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 조회 실패").setMessage("해당 게시물이 존재하지 않습니다.").setUrl("boardList.html")
					.setUrlTitle("목록으로");

		} catch (BizPasswordNotMatchedException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 삭제 실패").setMessage("비밀번호를 확인하여 주세요.");
		}

		model.addAttribute("messageVO", messageVO);
		return "common/message";

	}

	@RequestMapping(value = "/boardRemove.mg", method = RequestMethod.POST)
	public String boardDeleteM(BoardSearchVO Board, HttpServletRequest req, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		try {
			boardService.removeBoardM(Board);

			messageVO.setResult(true).setTitle("게시판 삭제 성공").setMessage("게시판의 정보를 삭제하였습니다.").setUrl("boardListM.mg")
					.setUrlTitle("목록으로");
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 조회 실패").setMessage("해당 게시물이 존재하지 않습니다.").setUrl("boardListM.mg")
					.setUrlTitle("목록으로");

		} catch (BizPasswordNotMatchedException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 삭제 실패").setMessage("비밀번호를 확인하여 주세요.");
		}

		model.addAttribute("messageVO", messageVO);
		return "common/message";

	}

}