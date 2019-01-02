package com.badboy.stock.mapper.daily;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.badboy.stock.bean.daily.HopenDaily;
import com.badboy.stock.common.datasource.myDataSource.BadboyDataSource;

@Mapper
public interface IHopenDailyapper extends BadboyDataSource{
	public void saveHopenDaily(HopenDaily hopenDaily);
	
	public List<HopenDaily> getHopenDailyList(String date);
}
