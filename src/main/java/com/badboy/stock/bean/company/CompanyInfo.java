package com.badboy.stock.bean.company;

import java.io.Serializable;
import java.util.Date;

import com.badboy.stock.commons.base.BaseBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfo extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 8341824157159632218L;
	
	@Getter@Setter
	private Long id ; //主键
	@Getter@Setter
	private String stockNo ; //
	@Getter@Setter
	private String companyName ; //公司名称
	@Getter@Setter
	private String companyEName ; //英文名称
	@Getter@Setter
	private String onceName ; //曾用名
	@Getter@Setter
	private String companyInfo ; //公司简介
	@Getter@Setter
	private Date companyCreateDate ; //公司成立时间
	@Getter@Setter
	private String companyNo ; //用工商登记号
	@Getter@Setter
	private String companyRegMoney ; //注册资本
	@Getter@Setter
	private String companyLegalPersion ; //法人代表
	@Getter@Setter
	private String industry ; //所属证监会行业
	@Getter@Setter
	private String empNum ; //员工人数
	@Getter@Setter
	private String companyGenManager ; //总经理
	@Getter@Setter
	private String companyManagerSecretary ; //董秘
	@Getter@Setter
	private String cityLevel1 ; //省会城市
	@Getter@Setter
	private String cityLevel2 ; //市级城市
	@Getter@Setter
	private String regCity ; //注册地址
	@Getter@Setter
	private String jobCity ; //办公地址
	@Getter@Setter
	private String zipCode ; //邮编
	@Getter@Setter
	private String companyTel ; //公司电话
	@Getter@Setter
	private String faxNum ; //传真
	@Getter@Setter
	private String mailAccount ; //邮箱
	@Getter@Setter
	private String companyUrl ; //公司网址
	@Getter@Setter
	private String auditOrg ; //审计机构
	@Getter@Setter
	private String lawConsultant ; //法律顾问
	@Getter@Setter
	private String busAnalysis ; //经营分析
	@Getter@Setter
	private String companyBrief ; //简史
	@Getter@Setter
	private Date updateTime ; //公司成立时间
}
