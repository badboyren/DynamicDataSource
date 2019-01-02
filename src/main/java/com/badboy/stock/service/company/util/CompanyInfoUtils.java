package com.badboy.stock.service.company.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.badboy.stock.bean.cninfo.CninfoStockCode;
import com.badboy.stock.bean.company.CompanyInfo;
import com.badboy.stock.enums.StockTypeEnum;
import com.badboy.stock.utils.constant.URIApi;
import com.badboy.stock.utils.date.DateUtils;

public class CompanyInfoUtils {

	public static CompanyInfo getCompanyInfo(CninfoStockCode code) {
		String num = code.getSssc().equals(StockTypeEnum.SH.getValue()) ? "01" : "02";
		CompanyInfo info = null;
		try {
			Document doc = Jsoup.connect(String.format(URIApi.company_Info_Api_, code.getStockNo(),num)).get();
			Elements elements = doc.select("#tablefont tr td p span");
			List<String> ele = new ArrayList<String>();
			for(int i=0;i<elements.size();i++) {
				if(i % 2 != 0) {
					ele.add(elements.get(i).text());
				}
			}
			if(ele.size() > 0) {
				info = new CompanyInfo();
				info.setStockNo(code.getStockNo());
				info.setCompanyName(ele.get(0));
				info.setCompanyEName(ele.get(1));
				info.setOnceName(ele.get(2));
				info.setCompanyInfo(ele.get(3));
				info.setCompanyCreateDate(DateUtils.stringToDate(ele.get(4)));
				info.setCompanyNo(ele.get(5));
				info.setCompanyRegMoney(ele.get(6));
				info.setCompanyLegalPersion(ele.get(7));
				info.setIndustry(ele.get(8));
				info.setEmpNum(ele.get(9));
				info.setCompanyGenManager(ele.get(10));
				info.setCompanyManagerSecretary(ele.get(11));
				info.setCityLevel1(ele.get(12));
				info.setCityLevel2(ele.get(13));
				info.setRegCity(ele.get(14));
				info.setJobCity(ele.get(15));
				info.setZipCode(ele.get(16));
				info.setCompanyTel(ele.get(17));
				info.setFaxNum(ele.get(18));
				info.setMailAccount(ele.get(19));
				info.setCompanyUrl(ele.get(20));
				info.setAuditOrg(ele.get(21));
				info.setLawConsultant(ele.get(22));
				info.setBusAnalysis(ele.get(23));
				info.setCompanyBrief(ele.get(24));
				info.setUpdateTime(new Date());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
}
