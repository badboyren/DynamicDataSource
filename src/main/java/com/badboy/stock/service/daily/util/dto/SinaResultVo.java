package com.badboy.stock.service.daily.util.dto;

import java.math.BigDecimal;

import com.badboy.stock.bean.daily.DailyInfo;

import lombok.Getter;
import lombok.Setter;

public class SinaResultVo extends DailyInfo {
	private static final long serialVersionUID = -770397563593490356L;
	
	@Getter@Setter
	public BigDecimal ydMoney;
}
