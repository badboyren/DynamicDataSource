package com.badboy.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.badboy.stock.service.cninfo.ICninfoService;
import com.badboy.stock.service.company.ICompanyInfoService;
import com.badboy.stock.service.org.ISecuritiesOrgService;

@RestController
public class GetCninfoInitData {

	@Autowired
	private ICninfoService cninfoService;
	
	@Autowired
	private ICompanyInfoService companyInfoService;
	
	@Autowired
	private ISecuritiesOrgService securitiesOrgService;
	
	@PostMapping("test")
	public void test() {
		cninfoService.saveCninfo();
	}
	
	@GetMapping("companyInfo")
	public void companyInfo() {
		companyInfoService.saveCompanyInfo();
	}
	
	@GetMapping("org")
	public void org() {
		securitiesOrgService.saveSecuritiesOrg();
	}
	
	@GetMapping("all")
	@ResponseBody
	public List createTable() {
		return cninfoService.getCninfoStockCodeAll();
	}
}
