package com.proj.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.proj.board.dao.IBoardDao;
import com.proj.board.vo.BoardSearchVO;
import com.proj.board.vo.BoardVO;
import com.proj.exception.BizException;
import com.proj.exception.BizNotEffectedException;
import com.proj.exception.BizNotFoundException;


@Service
public class BoardServiceImpl implements IBoardService{ 
	
	@Autowired
	private IBoardDao boardDao; 
	

	
	@Override
	public BoardVO getBoard(int boNum) throws BizException {
		
			BoardVO board = boardDao.getBoard(boNum);
			if(board == null) {
				throw new BizNotFoundException("게시판 [ "+ boNum + " ] 조회 실패");
			}
			
			return board;
		
	}

	
	@Override
	public void registBoard(BoardVO board) throws BizException {
		try {
			int cnt = boardDao.insertBoard(board);
			if(cnt < 1) {
				throw new BizNotEffectedException("게시판 등록이 되지 않았습니다.", board);
			}
		
		}catch (DuplicateKeyException e) {
			throw new DuplicateKeyException(e.getMessage(), e);
		}
	}

	
	@Override
	public void modifyBoard(BoardVO board) throws BizException {
	
			//패스워드 비교
			BoardVO vo = boardDao.getBoard(board.getBoNum());
			if(vo == null) {
				throw new BizNotFoundException("글번호 [" + board.getBoNum() + "] 이 존재하지 않습니다.");
			}

		
			int cnt = boardDao.updateBoard(board);
			if(cnt < 1) {
				throw new BizNotEffectedException("게시판 정보 수정이 되지 않았습니다.", board);
			}
	
	}

	
	@Override
	public void removeBoard(BoardVO board) throws BizException {
			
			int cnt = boardDao.deleteBoard(board);
			if(cnt < 1) {
				throw new BizNotEffectedException("게시판 삭제가 되지 않았습니다.", board);
			}
	}
	
	@Override
	public void removeBoardM(BoardSearchVO board) throws BizException {
		
		int cnt = boardDao.deleteBoardM(board);
		if(cnt < 1) {
			throw new BizNotEffectedException("게시판 삭제가 되지 않았습니다.", board);
		}
	}

	
	@Override
	public void increaseHit(int boNum) throws BizException {
		boardDao.increaseHit(boNum);
	}


	@Override
	public List<BoardVO> getBoardList(BoardSearchVO searchVO) throws BizException {
		int cnt = boardDao.getBoardCount(searchVO);
		searchVO.setTotalRowCount(cnt);
		searchVO.setting();
		List<BoardVO> list = boardDao.getBoardList(searchVO);

		return list;
		
	}
	
	@Override
	public List<BoardVO> getBoardListM(BoardSearchVO searchVO) throws BizException {
		int cnt = boardDao.getBoardCount(searchVO);
		searchVO.setTotalRowCount(cnt);
		searchVO.setting();
		List<BoardVO> list = boardDao.getBoardList(searchVO);
		
		return list;
		
	}


	
	
	

	
}
