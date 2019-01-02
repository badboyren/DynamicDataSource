package com.badboy.stock.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static SimpleDateFormat getInstance() {
		return new SimpleDateFormat(DATE_FORMAT);
	}
	
	public static SimpleDateFormat getInstance(String format) {
		return new SimpleDateFormat(format);
	}
	public static Date stringToDate(String date) {
		Date dt = null;
	    try { 
			 dt =  getInstance().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	public static String getDateTime() {
		return  getInstance(TIME_FORMAT).format(new Date());
	}
	public static String getDate() {
		return  getInstance(DATE_FORMAT).format(new Date());
	}
}
