package com.proj.common.vo;

public class TableVO {

	private String tableName;  /*expr, food, stay...etc*/
	private int rowNo;         /*테이블 내의 구분번호*/
	

	public TableVO() {
		super();
	}	
	public TableVO(String tableName, int rowNo) {
		super();
		this.tableName = tableName;
		this.rowNo = rowNo;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getRowNo() {
		return rowNo;
	}
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	
}
