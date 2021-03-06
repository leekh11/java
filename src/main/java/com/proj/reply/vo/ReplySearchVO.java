package com.proj.reply.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.proj.common.vo.PagingVO;

@SuppressWarnings("serial")
public class ReplySearchVO extends PagingVO{
	
	private String reCategory; /* 분류(FREE, BOARD,PDS,..) */
	private int reParentNo; /* 부모 번호 */
	
	
	
	public String getReCategory() {
		return reCategory;
	}
	public int getReParentNo() {
		return reParentNo;
	}
	public void setReCategory(String reCategory) {
		this.reCategory = reCategory;
	}
	public void setReParentNo(int reParentNo) {
		this.reParentNo = reParentNo;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	

}
