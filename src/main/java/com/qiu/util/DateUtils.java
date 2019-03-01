package com.qiu.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Project:PiggyBank
 * File:com.qiu.util
 * Author:qiufan
 * Email :qiufan@homolo.com
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
public abstract class DateUtils {
	public static final int FIELD_YEAR = 1;
	public static final long ONEDAYTIMES = 86400000L;

	public DateUtils() {
	}

	public static boolean compare(Date arg0, Date arg1) {
		if (arg0 == null && arg1 == null) {
			return true;
		} else if (arg0 != null && arg1 != null) {
			return arg0.getTime() == arg1.getTime();
		} else {
			return false;
		}
	}

	public static boolean isToday(Date date) {
		return org.apache.commons.lang3.time.DateUtils.isSameDay(date, new Date());
	}

	public static boolean afterNow(Date date) {
		return date.getTime() > System.currentTimeMillis();
	}

	public static boolean beforeNow(Date date) {
		return date.getTime() < System.currentTimeMillis();
	}

	public static void cutTime(Calendar cal) {
		cal.set(11, cal.getActualMinimum(11));
		cal.set(12, cal.getActualMinimum(12));
		cal.set(13, cal.getActualMinimum(13));
		cal.set(14, cal.getActualMinimum(14));
	}

	public static Date cutTime(Date date) {
		return dayStart(date);
	}

	public static void fillTime(Calendar cal) {
		cal.set(11, cal.getActualMaximum(11));
		cal.set(12, cal.getActualMaximum(12));
		cal.set(13, cal.getActualMaximum(13));
		cal.set(14, cal.getActualMaximum(14));
	}

	public static Date fillTime(Date date) {
		return dayEnd(date);
	}

	public static Date getWeekBeginDate(Date date) {
		if (date == null) {
			date = new Date();
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(7, 1);
		cutTime((Calendar)cal);
		return cal.getTime();
	}

	public static Date getWeekEndDate(Date date) {
		if (date == null) {
			date = new Date();
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(7, 7);
		fillTime((Calendar)cal);
		return cal.getTime();
	}

	public static Date getMonthBeginDate(Date date) {
		if (date == null) {
			date = new Date();
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(5, 1);
		cutTime((Calendar)cal);
		return cal.getTime();
	}

	public static Date getMonthEndDate(Date date) {
		if (date == null) {
			date = new Date();
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(2, cal.get(2) + 1);
		cal.set(5, 0);
		fillTime((Calendar)cal);
		return cal.getTime();
	}

	public static Date getYearBeginDate(Date date) {
		if (date == null) {
			date = new Date();
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(5, 1);
		cal.set(2, 0);
		cutTime((Calendar)cal);
		return cal.getTime();
	}

	public static Date getYearEndDate(Date date) {
		if (date == null) {
			date = new Date();
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(2, 12);
		cal.set(5, 0);
		fillTime((Calendar)cal);
		return cal.getTime();
	}

	public static Date yearStart(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(2, cal.getActualMinimum(2));
		cal.set(5, cal.getActualMinimum(5));
		cal.set(11, cal.getActualMinimum(11));
		cal.set(12, cal.getActualMinimum(12));
		cal.set(13, cal.getActualMinimum(13));
		cal.set(14, cal.getActualMinimum(14));
		return cal.getTime();
	}

	public static Date yearEnd(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(2, cal.getActualMaximum(2));
		cal.set(5, cal.getActualMaximum(5));
		cal.set(11, cal.getActualMaximum(11));
		cal.set(12, cal.getActualMaximum(12));
		cal.set(13, cal.getActualMaximum(13));
		cal.set(14, cal.getActualMaximum(14));
		return cal.getTime();
	}

	public static Date monthStart(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(5, cal.getActualMinimum(5));
		cal.set(11, cal.getActualMinimum(11));
		cal.set(12, cal.getActualMinimum(12));
		cal.set(13, cal.getActualMinimum(13));
		cal.set(14, cal.getActualMinimum(14));
		return cal.getTime();
	}

	public static Date monthEnd(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(5, cal.getActualMaximum(5));
		cal.set(11, cal.getActualMaximum(11));
		cal.set(12, cal.getActualMaximum(12));
		cal.set(13, cal.getActualMaximum(13));
		cal.set(14, cal.getActualMaximum(14));
		return cal.getTime();
	}

	public static Date dayStart(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(11, cal.getActualMinimum(11));
		cal.set(12, cal.getActualMinimum(12));
		cal.set(13, cal.getActualMinimum(13));
		cal.set(14, cal.getActualMinimum(14));
		return cal.getTime();
	}

	public static Date dayEnd(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(11, cal.getActualMaximum(11));
		cal.set(12, cal.getActualMaximum(12));
		cal.set(13, cal.getActualMaximum(13));
		cal.set(14, cal.getActualMaximum(14));
		return cal.getTime();
	}

	public static Date parseDate(String s) {
		return new Date(Long.parseLong(s));
	}

	public static int getBetweenDays(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		if (c1.after(c2)) {
			c1.setTime(d2);
			c2.setTime(d1);
		}

		int betweenYears = c2.get(1) - c1.get(1);
		int betweenDays = c2.get(6) - c1.get(6);

		for(int i = 0; i < betweenYears; ++i) {
			betweenDays += c1.getActualMaximum(6);
			c1.set(1, c1.get(1) + 1);
		}

		return betweenDays;
	}

	public static int getYear(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c.get(1);
	}

	public static int getMonth(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c.get(2);
	}

	public static int getDate(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c.get(5);
	}

	public static void main(String[] args) {
		System.out.println(getBetweenDays(FormatUtils.parseDate("2011-12-31"), FormatUtils.parseDate("2012-03-01")));
	}

	public static String format(Date date) {
		return format(date, new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String format(Date date1, Date date2, String format) {
		if (date1 != null && date2 != null) {
			long day_millis = 86400000L;
			long offset = date2.getTime() - date1.getTime();
			long day = offset / day_millis;
			return day > 30L && StringUtils.isNotBlank(format) ? DateFormatUtils.format(date2, format) : format(offset);
		} else {
			return "";
		}
	}

	public static String format(long offset) {
		long day_millis = 86400000L;
		long hour_millis = 3600000L;
		long minute_millis = 60000L;
		long second_millis = 1000L;
		long day = offset / day_millis;
		long hour = offset % day_millis / hour_millis;
		long minute = offset % day_millis % hour_millis / minute_millis;
		long second = offset % day_millis % hour_millis % minute_millis / second_millis;
		String time = "";
		if (day != 0L) {
			time = time + Math.abs(day) + "天";
		}

		if (hour != 0L) {
			time = time + Math.abs(hour) + "小时";
		}

		if (minute != 0L) {
			time = time + Math.abs(minute) + "分";
		}

		if (second != 0L) {
			time = time + Math.abs(second) + "秒";
		}

		if (StringUtils.isBlank(time)) {
			time = "0";
		}

		return time;
	}
}
