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
public class DailyInfo extends BaseBean implements Serializable{
	private static final long serialVersionUID = 6774872769259946034L;
	@Getter@Setter
	public BigDecimal openMoney;
	@Getter@Setter
	public BigDecimal closeMoney;
	@Getter@Setter
	public BigDecimal maxMoney;
	@Getter@Setter
	public BigDecimal minMoney;
	@Getter@Setter
	public BigDecimal ydMoney; 
	@Getter@Setter
	public Date tDate;
}
