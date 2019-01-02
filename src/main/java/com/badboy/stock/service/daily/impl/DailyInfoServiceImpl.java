package com.badboy.stock.service.daily.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badboy.stock.bean.cninfo.CninfoStockCode;
import com.badboy.stock.bean.daily.DailyInfo;
import com.badboy.stock.bean.daily.ext.DailyInfoExt;
import com.badboy.stock.mapper.cninfo.ICninfoMapper;
import com.badboy.stock.mapper.daily.IDailyInfoMapper;
import com.badboy.stock.service.daily.IDailyInfoService;
import com.badboy.stock.service.daily.util.DailyUtil;
import com.badboy.stock.utils.constant.Constant;

@Service
public class DailyInfoServiceImpl implements IDailyInfoService{
	
	@Autowired
	private ICninfoMapper cninfoDao;
	
	@Autowired
	private IDailyInfoMapper dailyInfoMapper;
	
	@Autowired
	private DailyUtil dailyUtil;

	@Override
	public void oneKeyTable() {
		List<CninfoStockCode> list = cninfoDao.getCninfoStockCodeAll();
		for(CninfoStockCode li : list) {
			String tableName = String.format(Constant.DAILYINFO_TABLE_NAME, li.getStockNo());
			System.out.println(tableName);
			dailyInfoMapper.createTable(tableName);
		}
	}
	@Override
	public void taskJobSave() {
		List<CninfoStockCode> list = cninfoDao.getCninfoStockCodeAll();
		DailyInfo dailyInfo= null;
		String tableName = null;
		for(CninfoStockCode li : list) {
			dailyInfo = new DailyInfo();
			DailyInfoExt dailyInfoExt = dailyUtil.getDailyInfoExt(li);
			tableName = String.format(Constant.DAILYINFO_TABLE_NAME, dailyInfoExt.getStockNo());
			BeanUtils.copyProperties(dailyInfoExt, dailyInfo);
			dailyInfoMapper.saveDailyInfo(tableName, dailyInfo);
		}
	}
}
