package com.badboy.stock.mapper.cninfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.badboy.stock.bean.cninfo.CninfoStockCode;
import com.badboy.stock.common.datasource.myDataSource.BadboyDataSource;

@Mapper
public interface ICninfoMapper extends BadboyDataSource{
	
	void saveCninfo(CninfoStockCode cninfoCode);
	void saveCninfoList(@Param("list") List<CninfoStockCode> list,@Param("sssc") String sssc);
	
	List<CninfoStockCode> getCninfoStockCodeAll();
}
