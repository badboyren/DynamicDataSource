package com.badboy.stock.bean.daily.ext;

import com.badboy.stock.bean.daily.DailyInfo;

import lombok.Getter;
import lombok.Setter;

public class DailyInfoExt extends DailyInfo {
	private static final long serialVersionUID = 65536234654696167L;
	@Getter@Setter
	public String stockNo;
}
