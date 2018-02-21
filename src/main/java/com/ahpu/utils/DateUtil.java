package com.ahpu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String formatDate(Date date) {

		String resultDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (date != null) {
			resultDate = sdf.format(date);
		}
		return resultDate;

	}

	public static String formatDateTotal(Date date) {

		String resultDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		if (date != null) {
			resultDate = sdf.format(date);
		}
		return resultDate;

	}

	public static Date formatReturnDate(Date date) {

		Date resultDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		if (date != null) {
			String str = sdf.format(date);
			try {
				resultDate = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return resultDate;

	}

}
