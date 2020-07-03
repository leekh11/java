package com.proj.board.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.proj.common.vo.PagingVO;

@SuppressWarnings("serial")
public class BoardSearchVO extends PagingVO {
	private String searchType;
	private String searchWord;
	private String searchCategory;
	private String[] boNos;
	
	public BoardSearchVO() {
		
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSearchCategory() {
		return searchCategory;
	}
	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	public String[] getBoNos() {
		return boNos;
	}

	public void setBoNos(String[] boNos) {
		this.boNos = boNos;
	}

}
