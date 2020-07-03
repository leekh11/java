package com.proj.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.code.dao.ICommonCodeDao;
import com.proj.code.vo.CodeVO;
import com.proj.exception.BizException;


@Service
public class CommonCodeServiceImpl implements ICommonCodeService{

	@Autowired
	private ICommonCodeDao codeDao;
	
	@Override
	public List<CodeVO> getCodeListByParent(String code) throws BizException {
			return codeDao.getCodeListByParent(code);
	}
}
