package com.badboy.stock.service.daily.util;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.badboy.stock.bean.cninfo.CninfoStockCode;
import com.badboy.stock.bean.daily.HopenDaily;
import com.badboy.stock.bean.daily.ext.DailyInfoExt;
import com.badboy.stock.enums.StockTypeEnum;
import com.badboy.stock.service.daily.util.dto.SinaResultVo;
import com.badboy.stock.utils.constant.URIApi;
import com.badboy.stock.utils.http.HttpClientUtil;

@Component
public class DailyUtil {

	protected String getSinaDailyApi(CninfoStockCode li) {
		String urlCode = StockTypeEnum.SH.getType().equals(li.getSssc())? "sh" : "sz";
		return String.format(URIApi.sina_Daily_api, urlCode+li.getStockNo());
	}
	protected String[] doFormatSinaResult(CninfoStockCode li) {
		String result = HttpClientUtil.sendGetRequest(getSinaDailyApi(li), null);
		String[] outs  = result.substring(result.indexOf("=\"")+2, result.lastIndexOf("\"")).split(",");
		return outs;
	}
	protected SinaResultVo doFormatSinaResult(String[] outs) {
		if(outs.length < 2 ) {
			return null;
		}
		SinaResultVo vo = new SinaResultVo();
		vo.setOpenMoney(new BigDecimal(outs[1]));
		vo.setYdMoney(new BigDecimal(outs[2]));
		vo.setCloseMoney(new BigDecimal(outs[3]));
		vo.setMaxMoney(new BigDecimal(outs[4]));
		vo.setMinMoney(new BigDecimal(outs[5]));
		vo.setTDate(new Date());
		return vo;
	}
	
	public HopenDaily getHopenDaily(CninfoStockCode li) {
		
		HopenDaily hopenDaily = null;
		
		String[] outs = doFormatSinaResult(li);
		if(outs.length <= 2) {
			return null;
		}
		SinaResultVo vo = doFormatSinaResult(outs);
		if(vo != null) {
			if(vo.getOpenMoney().compareTo(vo.getYdMoney()) != -1) { 
				hopenDaily = new HopenDaily();
				hopenDaily.setStockNo(li.getStockNo());
				hopenDaily.setTDate(new Date());
				hopenDaily.setTdMoney(vo.getOpenMoney());
				hopenDaily.setYdMoney(vo.getYdMoney());
			}
		}
		return hopenDaily;
	}
	
	public DailyInfoExt getDailyInfoExt(CninfoStockCode li) {
		
		DailyInfoExt dailyInfoExt = null;
		
		String[] outs = doFormatSinaResult(li);
		if(outs.length <= 2) {
			return null;
		}
		SinaResultVo vo = doFormatSinaResult(outs);
		if(vo != null) {
			dailyInfoExt = new DailyInfoExt();
			BeanUtils.copyProperties(vo, dailyInfoExt);
			dailyInfoExt.setStockNo(li.getStockNo());
			dailyInfoExt.setTDate(new Date());
		}
		return dailyInfoExt;
	}
	
}
