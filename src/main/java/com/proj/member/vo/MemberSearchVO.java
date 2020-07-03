package com.proj.member.vo;

import com.proj.common.vo.PagingVO;

@SuppressWarnings("serial")
public class MemberSearchVO extends PagingVO {
	private String searchType;
	private String searchWord;
	
	private String[] memIds;
	
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

	public MemberSearchVO(String searchType, String searchWord, String searchJob, String searchLike) {
		super();
		this.searchType = searchType;
		this.searchWord = searchWord;
	}
	public MemberSearchVO() {
		// TODO Auto-generated constructor stub
	}
	public String[] getMemIds() {
		return memIds;
	}
	public void setMemIds(String[] memIds) {
		this.memIds = memIds;
	}
	
}
