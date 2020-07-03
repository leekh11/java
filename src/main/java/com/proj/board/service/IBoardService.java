package com.proj.board.service;

import java.util.List;

import com.proj.board.vo.BoardSearchVO;
import com.proj.board.vo.BoardVO;
import com.proj.exception.BizException;

public interface IBoardService {
	  public List<BoardVO> getBoardList(BoardSearchVO searchVO) throws BizException;	
	  public List<BoardVO> getBoardListM(BoardSearchVO searchVO) throws BizException;	
	  public BoardVO getBoard(int boNum) throws BizException;	
	  public void registBoard(BoardVO board) throws BizException;	
	  public void modifyBoard(BoardVO board) throws BizException;	
	  public void removeBoard(BoardVO board) throws BizException;	
	  public void removeBoardM(BoardSearchVO board) throws BizException;	
	  public void increaseHit(int boNum) throws BizException;
	  


}
