package com.badboy.stock.mapper.cninfo;

import org.apache.ibatis.annotations.Mapper;

import com.badboy.stock.bean.cninfo.CninfoJson;
import com.badboy.stock.common.datasource.myDataSource.BadboyDataSource;

@Mapper
public interface ICninfoJsonMapper extends BadboyDataSource{
	CninfoJson selectCninfoJsonByType(String type);
}
