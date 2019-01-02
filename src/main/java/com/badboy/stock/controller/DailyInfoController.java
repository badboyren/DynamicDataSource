package com.badboy.stock.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.badboy.stock.bean.daily.HopenDaily;
import com.badboy.stock.service.daily.IDailyInfoService;
import com.badboy.stock.service.daily.IHopenDailyService;
import com.badboy.stock.utils.date.DateUtils;

@RestController
public class DailyInfoController {
	@Autowired
	private IDailyInfoService dailyInfoService;
	
	@Autowired
	private IHopenDailyService hopenDailyService;
	
	@GetMapping("onekey")
	public void onkeyCreateTable() {
		dailyInfoService.oneKeyTable();
	}
	@GetMapping("open")
	public void openSave() {
		hopenDailyService.seve();;
	}
	
	@GetMapping("list")
	@ResponseBody
	public List<HopenDaily> list() {
		return hopenDailyService.getHopenDailyList(DateUtils.getDate());
	}
}
