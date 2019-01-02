package com.badboy.stock.bean.cninfo;

import java.io.Serializable;
import java.util.Date;

import com.badboy.stock.commons.base.BaseBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 */
@NoArgsConstructor
@AllArgsConstructor
public class CninfoJson extends BaseBean implements Serializable {
	private static final long serialVersionUID = 5735126777319238498L;
	@Getter@Setter
	private String type; 
	@Getter@Setter
	private String json; 
}
