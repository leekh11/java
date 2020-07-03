package com.proj.board.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.proj.attach.vo.AttachVO;

@SuppressWarnings("serial")
public class BoardVO implements Serializable {
	
	
	private int boNum;          /*글번호 */
	
	private String boId;       /*작성자 ID*/
	
	private String boTitle;        /*글제목 */
	private String boArea;        
	private String boTheme;       
	
	private String boContent;      /*내용 */	
	
	private String boRegDate;      /*등록일자 */
	private String boDelYn;        /*삭제 여부 */
	private int boHit;          /*조회수 */
	private int boLikes;          /*좋아요 */
	private String boAreaNm;
	private String boThemeNm;
	
	// --------------------------------------------------
	
	/* 첨부파일 리스트 
	 * Board : attach = 1 : N 관계 (collection)
	 * */
	private List<AttachVO> attaches ;

	/* 수정 할 때 삭제할 대상 첨부파일 번호 */
	private int[] delAtchNos;
	
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	
	
	
	
	

	public List<AttachVO> getAttaches() {
		return attaches;
	}



	public int[] getDelAtchNos() {
		return delAtchNos;
	}



	public void setAttaches(List<AttachVO> attaches) {
		this.attaches = attaches;
	}



	public void setDelAtchNos(int[] delAtchNos) {
		this.delAtchNos = delAtchNos;
	}








	public int getBoNum() {
		return boNum;
	}








	public String getBoId() {
		return boId;
	}








	public String getBoTitle() {
		return boTitle;
	}








	public String getBoArea() {
		return boArea;
	}








	public String getBoTheme() {
		return boTheme;
	}








	public String getBoContent() {
		return boContent;
	}








	public String getBoRegDate() {
		return boRegDate;
	}








	public String getBoDelYn() {
		return boDelYn;
	}








	public int getBoHit() {
		return boHit;
	}








	public int getBoLikes() {
		return boLikes;
	}








	public void setBoNum(int boNum) {
		this.boNum = boNum;
	}








	public void setBoId(String boId) {
		this.boId = boId;
	}








	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}








	public void setBoArea(String boArea) {
		this.boArea = boArea;
	}








	public void setBoTheme(String boTheme) {
		this.boTheme = boTheme;
	}








	public void setBoContent(String boContent) {
		this.boContent = boContent;
	}








	public void setBoRegDate(String boRegDate) {
		this.boRegDate = boRegDate;
	}








	public void setBoDelYn(String boDelYn) {
		this.boDelYn = boDelYn;
	}








	public void setBoHit(int boHit) {
		this.boHit = boHit;
	}








	public void setBoLikes(int boLikes) {
		this.boLikes = boLikes;
	}








	public String getBoAreaNm() {
		return boAreaNm;
	}








	public String getBoThemeNm() {
		return boThemeNm;
	}








	public void setBoAreaNm(String boAreaNm) {
		this.boAreaNm = boAreaNm;
	}








	public void setBoThemeNm(String boThemeNm) {
		this.boThemeNm = boThemeNm;
	}


	
	





	
	
}
