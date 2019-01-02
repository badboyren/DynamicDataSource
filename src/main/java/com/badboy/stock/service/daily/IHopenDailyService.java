package com.badboy.stock.service.daily;

import java.util.Date;
import java.util.List;

import com.badboy.stock.bean.daily.HopenDaily;

public interface IHopenDailyService {
	public void seve();
	public void taskJobSave();
	
	public List<HopenDaily> getHopenDailyList(String date);
}
