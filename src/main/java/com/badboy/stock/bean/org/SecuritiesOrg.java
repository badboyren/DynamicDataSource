package com.badboy.stock.bean.org;

import java.io.Serializable;
import java.util.Date;

import com.badboy.stock.commons.base.BaseBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class SecuritiesOrg extends BaseBean implements Serializable{
	private static final long serialVersionUID = -8434997479206720463L;
	@Getter@Setter
	private Long id ; //
	@Getter@Setter
	private String orgName ; //机构名称
	@Getter@Setter
	private String pyjc ; //拼音简称
	@Getter@Setter
	private String pyjcFirst ; //首字母
	@Getter@Setter
	private Date updateTime ; //修改时间
	@Getter@Setter
	private String orgUrl; //机构url
}
