package com.proj.code.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("serial")
public class CodeVO implements Serializable {

	private String boCode; /**/
	private String boNm; /**/
	private String boPa; /**/

	public CodeVO(String boCode, String boNm, String boPa) {
		super();
		this.boCode = boCode;
		this.boNm = boNm;
		this.boPa = boPa;
	}

	public CodeVO() {
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}


	public String getBoCode() {
		return boCode;
	}

	public void setBoCode(String boCode) {
		this.boCode = boCode;
	}

	public String getBoNm() {
		return boNm;
	}

	public void setBoNm(String boNm) {
		this.boNm = boNm;
	}

	public String getBoPa() {
		return boPa;
	}

	public void setBoPa(String boPa) {
		this.boPa = boPa;
	}

}
