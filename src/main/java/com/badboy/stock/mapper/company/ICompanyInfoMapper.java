package com.badboy.stock.mapper.company;

import org.apache.ibatis.annotations.Mapper;

import com.badboy.stock.bean.company.CompanyInfo;
import com.badboy.stock.common.datasource.myDataSource.BadboyDataSource;

@Mapper
public interface ICompanyInfoMapper extends BadboyDataSource{
	void saveCompanyInfo(CompanyInfo companyInfo);
}
