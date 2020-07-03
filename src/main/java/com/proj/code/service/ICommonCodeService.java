package com.proj.code.service;

import java.util.List;

import com.proj.code.vo.CodeVO;
import com.proj.exception.BizException;

public interface ICommonCodeService {
	
	List<CodeVO> getCodeListByParent(String code) throws BizException;
	
}
