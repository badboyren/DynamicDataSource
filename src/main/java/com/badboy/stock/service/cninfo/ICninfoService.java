package com.badboy.stock.service.cninfo;

import java.util.List;

import com.badboy.stock.bean.cninfo.CninfoStockCode;

public interface ICninfoService {
	void saveCninfo();
	
	List<CninfoStockCode> getCninfoStockCodeAll();
}
