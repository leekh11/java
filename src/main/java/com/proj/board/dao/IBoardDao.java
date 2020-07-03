package com.proj.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.board.vo.BoardVO;
import com.proj.exception.BizException;
import com.proj.exception.DaoException;
import com.proj.board.vo.BoardSearchVO;


@Mapper
public interface IBoardDao {
	
	  public int getBoardCount(BoardSearchVO searchVO) throws DaoException;	
	
	  public List<BoardVO> getBoardList(BoardSearchVO serchVO) throws BizException;

	  //	  관리자용 페이지
	  public List<BoardVO> getBoardListM(BoardSearchVO serchVO) throws BizException;
	
	  public BoardVO getBoard(int boNum) throws DaoException;	
	  
	  public int insertBoard(BoardVO board) throws DaoException;	
	  
	  public int updateBoard(BoardVO board) throws DaoException;	
	  public int deleteBoard(BoardVO board) throws DaoException;
	  public int deleteBoardM(BoardSearchVO board) throws DaoException;

	  public int increaseHit(int boNum) throws DaoException;

}
