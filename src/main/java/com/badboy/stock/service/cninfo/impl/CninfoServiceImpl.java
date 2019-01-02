package com.badboy.stock.service.cninfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.badboy.stock.bean.cninfo.CninfoJson;
import com.badboy.stock.bean.cninfo.CninfoStockCode;
import com.badboy.stock.enums.StockTypeEnum;
import com.badboy.stock.mapper.cninfo.ICninfoJsonMapper;
import com.badboy.stock.mapper.cninfo.ICninfoMapper;
import com.badboy.stock.service.cninfo.ICninfoService;

@Service
public class CninfoServiceImpl implements ICninfoService{
	
	@Autowired
	private ICninfoMapper  cninfoDao;
	@Autowired
	private ICninfoJsonMapper  cninfoJsonDao;

	@Override
	public void saveCninfo() {
		String ShType = StockTypeEnum.SH.getValue();
		CninfoJson shJson = cninfoJsonDao.selectCninfoJsonByType(ShType);
		List<CninfoStockCode> shList = JSON.parseArray(shJson.getJson().trim(), CninfoStockCode.class);
		cninfoDao.saveCninfoList(shList, ShType);
		
		ShType = StockTypeEnum.SZ.getValue();
		CninfoJson szJson = cninfoJsonDao.selectCninfoJsonByType(ShType);
		List<CninfoStockCode> szList = JSON.parseArray(szJson.getJson().trim(), CninfoStockCode.class);
		cninfoDao.saveCninfoList(szList, ShType);
	}

	@Override
	public List<CninfoStockCode> getCninfoStockCodeAll() {
		return cninfoDao.getCninfoStockCodeAll();
	}
}
