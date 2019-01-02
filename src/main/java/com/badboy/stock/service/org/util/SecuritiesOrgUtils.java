package com.badboy.stock.service.org.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.badboy.stock.bean.org.SecuritiesOrg;
import com.badboy.stock.utils.constant.URIApi;
import com.badboy.stock.utils.pinyin4j.PinyinTool;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class SecuritiesOrgUtils {
	public static List<SecuritiesOrg> getSecuritiesOrg() {
		List<SecuritiesOrg> list = null;
		try {
			Document doc = Jsoup.connect(String.format(URIApi.securities_org_url)).get();
			Elements ele = doc.select("div .company-container").select(".clearfix");
			ele  = ele.select(".company").select(".c-name a");
			if(ele.size() > 0) {
				list = new ArrayList<SecuritiesOrg>();
				SecuritiesOrg temp = null;
				String pinyin = "";
				for(Element el : ele) {
					pinyin = PinyinTool.toPinYinFirstUpper(el.text());
					temp = new SecuritiesOrg();
					temp.setOrgName(el.text());
					temp.setPyjc(pinyin);
					temp.setPyjcFirst(pinyin.substring(0, 1).toUpperCase());
					temp.setOrgUrl(URIApi.eastmoney_data_url +el.attr("href"));
					list.add(temp);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		getSecuritiesOrg();
	}
}
