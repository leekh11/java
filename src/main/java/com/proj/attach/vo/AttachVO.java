package com.proj.attach.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AttachVO {

	private int atchNo;          /**/
	private int atchParentNo;    /**/
	private String atchFileName;    /**/
	private String atchOriginalName;  /**/
	private int atchFileSize;    /**/
	private String atchFancySize;   /**/
	private String atchContentType;  /**/
	private String atchPath;        /**/
	private String atchDelYn;       /**/
	private String atchRegDate;     /**/
	
	@Override
	public String toString() {
		// apache commons Lang TostringBuilder 
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public AttachVO(int atchNo, int atchParentNo, String atchFileName, String atchOriginalName, int atchFileSize,
			String atchFancySize, String atchContentType, String atchPath, String atchDelYn, String atchRegDate) {
		super();
		this.atchNo = atchNo;
		this.atchParentNo = atchParentNo;
		this.atchFileName = atchFileName;
		this.atchOriginalName = atchOriginalName;
		this.atchFileSize = atchFileSize;
		this.atchFancySize = atchFancySize;
		this.atchContentType = atchContentType;
		this.atchPath = atchPath;
		this.atchDelYn = atchDelYn;
		this.atchRegDate = atchRegDate;
	}
	
	public AttachVO() {
		// TODO Auto-generated constructor stub
	}

	public int getAtchNo() {
		return atchNo;
	}

	public void setAtchNo(int atchNo) {
		this.atchNo = atchNo;
	}

	public int getAtchParentNo() {
		return atchParentNo;
	}

	public void setAtchParentNo(int atchParentNo) {
		this.atchParentNo = atchParentNo;
	}

	public String getAtchFileName() {
		return atchFileName;
	}

	public void setAtchFileName(String atchFileName) {
		this.atchFileName = atchFileName;
	}

	public String getAtchOriginalName() {
		return atchOriginalName;
	}

	public void setAtchOriginalName(String atchOriginalName) {
		this.atchOriginalName = atchOriginalName;
	}

	public int getAtchFileSize() {
		return atchFileSize;
	}

	public void setAtchFileSize(int atchFileSize) {
		this.atchFileSize = atchFileSize;
	}

	public String getAtchFancySize() {
		return atchFancySize;
	}

	public void setAtchFancySize(String atchFancySize) {
		this.atchFancySize = atchFancySize;
	}

	public String getAtchContentType() {
		return atchContentType;
	}

	public void setAtchContentType(String atchContentType) {
		this.atchContentType = atchContentType;
	}

	public String getAtchPath() {
		return atchPath;
	}

	public void setAtchPath(String atchPath) {
		this.atchPath = atchPath;
	}

	public String getAtchDelYn() {
		return atchDelYn;
	}

	public void setAtchDelYn(String atchDelYn) {
		this.atchDelYn = atchDelYn;
	}

	public String getAtchRegDate() {
		return atchRegDate;
	}

	public void setAtchRegDate(String atchRegDate) {
		this.atchRegDate = atchRegDate;
	}
	
}
