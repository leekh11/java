package com.proj.festival.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FestivalVO {
	private String mapx;            /**/
	private String mapy;            /**/
	private int no;              /**/
	private String name;            /**/
	private int areaCode;        /**/
	private String add1;            /**/
	private String add2;            /**/
	private String keyword;         /**/
	private String imageUrl;        /**/
	private String publicYn;        /**/
	private int stDate;          /**/
	private int endDate;         /**/
	private int hit;             /**/
	private int likes;           /**/
	private int grade;           /**/
	private String tableCode;       /**/
	private String AreaNm;
	
	@Override
	public String toString() {
		// apache commons Lang TostringBuilder 
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
	public FestivalVO() {
	}

	public FestivalVO(String mapx, String mapy, int no, String name, int areaCode, String add1, String add2,
			String keyword, String imageUrl, String publicYn, int stDate, int endDate, int hit, int likes, int grade,
			String tableCode) {
		super();
		this.mapx = mapx;
		this.mapy = mapy;
		this.no = no;
		this.name = name;
		this.areaCode = areaCode;
		this.add1 = add1;
		this.add2 = add2;
		this.keyword = keyword;
		this.imageUrl = imageUrl;
		this.publicYn = publicYn;
		this.stDate = stDate;
		this.endDate = endDate;
		this.hit = hit;
		this.likes = likes;
		this.grade = grade;
		this.tableCode = tableCode;
	}

	public String getMapx() {
		return mapx;
	}

	public void setMapx(String mapx) {
		this.mapx = mapx;
	}

	public String getMapy() {
		return mapy;
	}

	public void setMapy(String mapy) {
		this.mapy = mapy;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPublicYn() {
		return publicYn;
	}

	public void setPublicYn(String publicYn) {
		this.publicYn = publicYn;
	}

	public int getStDate() {
		return stDate;
	}

	public void setStDate(int stDate) {
		this.stDate = stDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}


	public String getAreaNm() {
		return AreaNm;
	}


	public void setAreaNm(String areaNm) {
		AreaNm = areaNm;
	}
	
	
	
}
