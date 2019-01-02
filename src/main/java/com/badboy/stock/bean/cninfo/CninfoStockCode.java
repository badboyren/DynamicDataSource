package com.badboy.stock.bean.cninfo;

import java.io.Serializable;
import java.util.Date;

import com.badboy.stock.commons.base.BaseBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  {"PYJC":"payh","SSRQ":"1991-04-03","ZQJC":"平安银行","SECCODE":"000001-SZE","SSBK":"SZE","ZQLX":"A股","MARKET":"000001"}
 * @author Administrator
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class CninfoStockCode extends BaseBean implements Serializable{
	private static final long serialVersionUID = 8813592275104920900L;
	@Getter@Setter
	private String stockNo; 
	@Getter@Setter
	private String pyjc; 
	@Getter@Setter
	private Date ssrq; 
	@Getter@Setter
	private String zqjc; 
	@Getter@Setter
	private String sssc; //SZ,SH
	@Getter@Setter
	private Date updateTime; 
	@Getter@Setter
	private String seccode; 
	@Getter@Setter
	private String market; 
}
