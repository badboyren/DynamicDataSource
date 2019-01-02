package com.badboy.stock.utils.constant;

public final class URIApi {
	//get API eastmoney
	//{1}=code
	//{2}=SH:01,SZ:02
	public static final String company_Info_Api_ = "http://f9.eastmoney.com/soft/gp3_511.php?code=%s%s";
	//域名
	public static final String eastmoney_data_url = "http://data.eastmoney.com";
	//get securities_org name
	public static final String securities_org_url = eastmoney_data_url +"/stock/yybcx.html";
	//机构每日明细统一  龙虎榜
	public static final String org_day_mmtj_url = "http://m.data.eastmoney.com/lhb/dailystockliststatistics";
	
	
	public static final String sina_Daily_api = "http://hq.sinajs.cn/list=%s";
}
