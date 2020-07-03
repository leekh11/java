package com.proj.member.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MemberVO {
	private String memId;           /**/
	private String memPass;         /**/
	private String memName;         /**/
	private String memSb;           /**/
	private String memBir;          /**/
	private String memTel;          /**/
	private String memEmail;        /**/
	private String memDelYn;        /**/
	private int memMileage;
	
	public int getMemMileage() {
		return memMileage;
	}

	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}

	@Override
	public String toString() {
		// apache commons Lang TostringBuilder 
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemSb() {
		return memSb;
	}

	public void setMemSb(String memSb) {
		this.memSb = memSb;
	}

	public String getMemBir() {
		return memBir;
	}

	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemDelYn() {
		return memDelYn;
	}

	public void setMemDelYn(String memDelYn) {
		this.memDelYn = memDelYn;
	}


	public MemberVO(String memId, String memPass, String memName, String memSb, String memBir, String memTel,
			String memEmail, String memDelYn, int memMileage) {
		super();
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memSb = memSb;
		this.memBir = memBir;
		this.memTel = memTel;
		this.memEmail = memEmail;
		this.memDelYn = memDelYn;
		this.memMileage = memMileage;
	}

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	
}
