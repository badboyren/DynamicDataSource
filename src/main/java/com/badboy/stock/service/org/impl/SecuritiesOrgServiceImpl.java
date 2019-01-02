package com.badboy.stock.service.org.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badboy.stock.bean.org.SecuritiesOrg;
import com.badboy.stock.mapper.org.ISecuritiesOrgMapper;
import com.badboy.stock.service.org.ISecuritiesOrgService;
import com.badboy.stock.service.org.util.SecuritiesOrgUtils;

@Service
public class SecuritiesOrgServiceImpl implements ISecuritiesOrgService{

	@Autowired
	private ISecuritiesOrgMapper securitiesOrgDao;
	
	@Override
	public void saveSecuritiesOrg() {
		List<SecuritiesOrg> list = SecuritiesOrgUtils.getSecuritiesOrg();
		if(list != null && list.size() >0){
			securitiesOrgDao.saveSecuritiesOrgList(list);
		}
	}
}
