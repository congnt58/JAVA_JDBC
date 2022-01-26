package com.vti.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
	private static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	
	public static String dateToStr(Date date, String pattern) {	
		if (date == null) {
			return null;
		}
		if (pattern != null) {
			format = new SimpleDateFormat(pattern);
		}
		return format.format(date);
	}
	
	public static Date strToDate(String date, String pattern) {
		if (pattern != null) {
			format = new SimpleDateFormat(pattern);
		}
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			if (pattern != null) {
				System.err.println("Truyen vao sai dinh dang => " + pattern);
			}else {
				System.err.println("Truyen vao sai dinh dang => dd-MM-yyyy" );
			}
		}
		return d;
	}
	
	
	
}
