package com.badboy.stock.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.badboy.stock.bean.daily.HopenDaily;
import com.badboy.stock.service.daily.IDailyInfoService;
import com.badboy.stock.service.daily.IHopenDailyService;
import com.badboy.stock.task.util.JxlsUtils;
import com.badboy.stock.utils.date.DateUtils;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.Configuration;
import net.sf.jxls.transformer.XLSTransformer;

@Component
public class TaskJob {
	
	protected  Logger logger  = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IHopenDailyService hopenDailyService;
	@Autowired
	private IDailyInfoService dailyInfoService;
	@Autowired
	private JxlsUtils jxlsUtils;
	
//	@Scheduled(cron = "0 31 9 ? * *")
	@Scheduled(cron = "0 0 10 ? * *")
	public void autoHopenData() throws Exception {
		logger.info(">>TaskJob -- autoHopenData -- start <<");
		hopenDailyService.taskJobSave();
		logger.info(">>TaskJob -- autoHopenData -- end   <<");
	}
	
	@Scheduled(cron = "0 5 15 ? * *")
	public void autoDailyInfo() {
		logger.info(">>TaskJob -- autoDailyInfo -- start <<");
		dailyInfoService.taskJobSave();
		logger.info(">>TaskJob -- autoDailyInfo -- end   <<");
	}
	
//	@Scheduled(cron = "0/5 * * * * *")
//	public void outHopenData() {
//		logger.info(">>TaskJob -- outHopenData -- start <<");
//        jxlsUtils.outHopenData(hopenDailyService.getHopenDailyList(DateUtils.getDate()));
//        logger.info(">>TaskJob -- outHopenData -- end   <<");
//	}
	
//	@Scheduled(cron = "0 30 10 ? * *")
//	@Scheduled(cron = "0/5 * * * * *")
//	public void sendMailHopenData() {
//		logger.info(">>TaskJob -- outHopenData -- start <<");
//        jxlsUtils.sendMailHopenData();
//        logger.info(">>TaskJob -- outHopenData -- end   <<");
//	}
}
