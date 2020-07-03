package com.proj.reply.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ReplyVO2 {

	public ReplyVO2(int reNo, String reMemId, String reContent, int reLike, int reHate, int reParentNo, int reMemName,
			String reRegDate) {
		super();
		this.reNo = reNo;
		this.reMemId = reMemId;
		this.reContent = reContent;
		this.reLike = reLike;
		this.reHate = reHate;
		this.reParentNo = reParentNo;
		this.reMemName = reMemName;
		this.reRegDate = reRegDate;
	}

	private int reNo;            /**/
	private String reMemId;         /**/
	private String reContent;       /**/
	private int reLike;          /**/
	private int reHate;          /**/
	private int reParentNo;          /**/
	private int reMemName;          /**/
	private String reRegDate;       /**/
	

	@Override
	public String toString() {
		// apache commons Lang TostringBuilder 
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}


	
	public ReplyVO2() {
		// TODO Auto-generated constructor stub
	}

	public int getReNo() {
		return reNo;
	}

	public void setReNo(int reNo) {
		this.reNo = reNo;
	}

	public String getReMemId() {
		return reMemId;
	}

	public void setReMemId(String reMemId) {
		this.reMemId = reMemId;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public int getReLike() {
		return reLike;
	}

	public void setReLike(int reLike) {
		this.reLike = reLike;
	}

	public int getReHate() {
		return reHate;
	}

	public void setReHate(int reHate) {
		this.reHate = reHate;
	}

	public String getReRegDate() {
		return reRegDate;
	}

	public void setReRegDate(String reRegDate) {
		this.reRegDate = reRegDate;
	}

	public int getReParentNo() {
		return reParentNo;
	}

	public void setReParentNo(int reParentNo) {
		this.reParentNo = reParentNo;
	}

	public int getReMemName() {
		return reMemName;
	}

	public void setReMemName(int reMemName) {
		this.reMemName = reMemName;
	}
	
	



}
