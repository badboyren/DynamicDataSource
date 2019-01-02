package com.badboy.stock.mapper.daily;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.badboy.stock.bean.daily.DailyInfo;
import com.badboy.stock.common.datasource.myDataSource.Badboy1DataSource;

@Mapper
public interface IDailyInfoMapper extends Badboy1DataSource{
	public String existsTable(@Param("tableName") String tableName);
	public void  createTable(@Param("tableName") String tableName);
	public void saveDailyInfo(@Param("tableName") String tableName,@Param("dailyInfo")DailyInfo dailyInfo);
}
