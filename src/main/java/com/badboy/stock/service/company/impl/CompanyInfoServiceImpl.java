package com.badboy.stock.service.company.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badboy.stock.bean.cninfo.CninfoStockCode;
import com.badboy.stock.bean.company.CompanyInfo;
import com.badboy.stock.mapper.cninfo.ICninfoMapper;
import com.badboy.stock.mapper.company.ICompanyInfoMapper;
import com.badboy.stock.service.company.ICompanyInfoService;
import com.badboy.stock.service.company.util.CompanyInfoUtils;

@Service
public class CompanyInfoServiceImpl implements ICompanyInfoService{
	
	@Autowired
	private ICompanyInfoMapper companyInfoDao;
	
	@Autowired
	private ICninfoMapper cninfoDao;

	@Override
	public void saveCompanyInfo() {
		 List<CninfoStockCode> list =  cninfoDao.getCninfoStockCodeAll();
		 if(list != null && list.size() > 0) {
			 for(CninfoStockCode li : list) {
				 CompanyInfo getCompanyInfo = CompanyInfoUtils.getCompanyInfo(li);
				 if(getCompanyInfo != null) {
					 companyInfoDao.saveCompanyInfo(getCompanyInfo);
				 }
			 }
		 }
	}
	
}
