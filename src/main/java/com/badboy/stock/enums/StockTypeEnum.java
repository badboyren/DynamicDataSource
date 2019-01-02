package com.badboy.stock.enums;

public enum StockTypeEnum {
	SH("SH"),SZ("SZ");
	private String type;
	StockTypeEnum(String type){
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return	this.type;
	}
}
