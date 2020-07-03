package com.proj.notice.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("serial")
public class NoticeVO implements Serializable  {
	
	private int noticeNo;        /**/
	private String noticeId;        /**/
	private String noticeTitle;     /**/
	private String noticeContent;   /**/
	private String noticeDelYn;     /**/
	private String noticeRegDate;   /**/
	
	@Override
	public String toString() {
		// apache commons Lang TostringBuilder 
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public NoticeVO(int noticeNo, String noticeId, String noticeTitle, String noticeContent, String noticeDelYn,
			String noticeRegDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDelYn = noticeDelYn;
		this.noticeRegDate = noticeRegDate;
	}
	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeDelYn() {
		return noticeDelYn;
	}

	public void setNoticeDelYn(String noticeDelYn) {
		this.noticeDelYn = noticeDelYn;
	}

	public String getNoticeRegDate() {
		return noticeRegDate;
	}

	public void setNoticeRegDate(String noticeRegDate) {
		this.noticeRegDate = noticeRegDate;
	}
	
	
}
