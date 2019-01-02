package com.badboy.stock.mapper.org;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.badboy.stock.bean.org.SecuritiesOrg;
import com.badboy.stock.common.datasource.myDataSource.BadboyDataSource;

public interface ISecuritiesOrgMapper extends BadboyDataSource{
	void saveSecuritiesOrg(SecuritiesOrg securitiesOrg);
	void saveSecuritiesOrgList(@Param("list") List<SecuritiesOrg> list);
}
