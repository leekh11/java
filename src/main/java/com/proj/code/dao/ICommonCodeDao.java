package com.proj.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.code.vo.CodeVO;
import com.proj.exception.DaoException;

@Mapper	//이걸 붙여야 빈이 된다
public interface ICommonCodeDao {
	/**
	 * <b>공통코드에 조회목록을 리턴한다.</b>
	 *  
	 * @param conn
	 * @param code
	 * @return 코드목록 List<CodeVO>
	 * @throws DaoException
	 */
	List<CodeVO> getCodeListByParent(String code) throws DaoException;
	
}
