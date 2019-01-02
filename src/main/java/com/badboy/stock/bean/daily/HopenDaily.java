package com.badboy.stock.bean.daily;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.badboy.stock.commons.base.BaseBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class HopenDaily extends BaseBean implements Serializable{
	private static final long serialVersionUID = 8596490230110237482L;
	
	@Getter@Setter
	private int id;
	@Getter@Setter
	private String stockNo;
	@Getter@Setter
	private Date tDate;
	@Getter@Setter
	private BigDecimal ydMoney;
	@Getter@Setter
	private BigDecimal tdMoney;
	
	
	//Ext
	@Getter@Setter
	private String stockName;
	@Getter@Setter
	private BigDecimal difMoney;
}
