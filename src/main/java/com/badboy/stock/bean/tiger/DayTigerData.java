package com.badboy.stock.bean.tiger;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.badboy.stock.commons.base.BaseBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class DayTigerData extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1006415566467753155L;
	@Getter@Setter
	private Long id ; //
	@Getter@Setter
	private Date date ; //每日日期
	@Getter@Setter
	private String stockNo ; //代码
	@Getter@Setter
	private String stockName ; //名称
	@Getter@Setter
	private BigDecimal closePrice ; //收盘价
	@Getter@Setter
	private String riseFull ; //涨跌幅度
	@Getter@Setter
	private String bOrgNum ; //买入机构数
	@Getter@Setter
	private String sOrgNum ; //卖出机构数
	@Getter@Setter
	private String bMoney ; //买入金额
	@Getter@Setter
	private String sMoney ; //卖出金额
	@Getter@Setter
	private String totalMarket ; //总成交额度
	@Getter@Setter
	private String orgTotalMarket ; //机构成交额占比
	@Getter@Setter
	private String turnoverRate ; //换手率
	@Getter@Setter
	private String comments ; //上榜原因
}
