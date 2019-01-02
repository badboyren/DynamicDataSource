package com.badboy.stock.service.daily.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badboy.stock.bean.cninfo.CninfoStockCode;
import com.badboy.stock.bean.daily.HopenDaily;
import com.badboy.stock.enums.StockTypeEnum;
import com.badboy.stock.mapper.cninfo.ICninfoMapper;
import com.badboy.stock.mapper.daily.IHopenDailyapper;
import com.badboy.stock.service.daily.IHopenDailyService;
import com.badboy.stock.service.daily.util.DailyUtil;
import com.badboy.stock.utils.constant.URIApi;
import com.badboy.stock.utils.http.HttpClientUtil;

@Service
public class HopenDailyServiceImpl implements IHopenDailyService{
	
	protected  Logger logger  = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IHopenDailyapper hopenDailyapper;
	@Autowired
	private ICninfoMapper cninfoDao;
	
	@Autowired
	private DailyUtil dailyUtil;
	
	@Override
	public void seve() {
		
	}
//	public static void main(String[] args) {
//		String result = HttpClientUtil.sendGetRequest("http://hq.sinajs.cn/list=sz002257", null);
//		String[] outs  = result.substring(result.indexOf("=\"")+2, result.lastIndexOf("\"")).split(",");
//		System.out.println(outs[0]);
//		System.out.println(outs.length);
//	}
	@Override
	public void taskJobSave() {
		List<CninfoStockCode> list =  cninfoDao.getCninfoStockCodeAll();
		HopenDaily hopenDaily = null;
		for(CninfoStockCode li : list) {
			hopenDaily = dailyUtil.getHopenDaily(li);
			if(hopenDaily != null ) {
				hopenDailyapper.saveHopenDaily(hopenDaily);
			}
		}
	}
	@Override
	public List<HopenDaily> getHopenDailyList(String date) {
		return hopenDailyapper.getHopenDailyList(date);
	}
}
