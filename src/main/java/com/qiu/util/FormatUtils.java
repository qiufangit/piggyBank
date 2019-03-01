package com.qiu.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class FormatUtils {
	private static final Logger logger = LoggerFactory.getLogger(FormatUtils.class);
	static Map<String, String> cnm = Maps.newLinkedHashMap();

	private FormatUtils() {
	}

	public static String formatDate(Date date, String format) {
		return date == null ? "" : (new SimpleDateFormat(format)).format(date);
	}

	public static Date parseDate(String str, String format) {
		try {
			return StringUtils.isEmpty(str) ? null : org.apache.commons.lang3.time.DateUtils.parseDate(str, new String[]{format});
		} catch (ParseException var3) {
			logger.error(var3.getMessage(), var3);
			return null;
		}
	}

	public static String formatDate(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}

	public static Date parseDate(String str) {
		try {
			return StringUtils.isEmpty(str) ? null : DateUtils.parseDate(str, new String[]{"yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ssZZ", "yyyyMMdd'T'HH:mm:ss", "yyyyMMdd'T'HHmmss'Z'", "yyyyMMdd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd", "yyyyMMdd", "yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ssX", "yyyy年MM月dd日", "yyyy年MM月dd日 HH:mm:ss", "yyyy年MM月dd日 HH:mm", "yyyy年MM月", "yyyy年M月", "yyyy-M", "yyyy-M-d"});
		} catch (ParseException var2) {
			return null;
		}
	}

	public static final String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static final Date parseDateTime(String str) {
		return parseDate(str, "yyyy-MM-dd HH:mm:ss");
	}

	public static final String formatDateToGMTWithWeek(Date date) {
		DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(date);
	}

	public static final Date parseDateToGMTWithWeek(String source) {
		try {
			DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
			format.setTimeZone(TimeZone.getTimeZone("GMT"));
			return format.parse(source);
		} catch (ParseException var2) {
			var2.printStackTrace();
			return null;
		}
	}

	public static Date smartParseDate(String source) {
		try {
			return new Date(source);
		} catch (IllegalArgumentException var2) {
			return parseDate(source);
		}
	}

	public static final String formatShortDate(Date date) {
		return formatDate(date, "MM-dd");
	}

	public static final String formatShortDateTime(Date date) {
		return formatDate(date, "MM-dd HH:mm");
	}

	public static final String formatCNDate(Date date) {
		return formatDate(date, "yyyy年MM月dd日");
	}

	public static final String formatCNWeekDay(Date date) {
		int day = date.getDay();
		switch(day) {
			case 0:
				return "星期日";
			case 1:
				return "星期一";
			case 2:
				return "星期二";
			case 3:
				return "星期三";
			case 4:
				return "星期四";
			case 5:
				return "星期五";
			case 6:
				return "星期六";
			default:
				return "error";
		}
	}

	public static final String formatJSONDate(Date date) {
		return formatDate(date, "yyyy-MM-dd'T'HH:mm:ss");
	}

	public static final Date parseJSONDate(String str) {
		return parseDate(str, "yyyy-MM-dd'T'HH:mm:ss");
	}

	public static final Date parseCNDate(String str) {
		String c;
		for(Iterator var1 = cnm.keySet().iterator(); var1.hasNext(); str = str.replaceAll(c, (String)cnm.get(c))) {
			c = (String)var1.next();
		}

		return parseDate(str, "yyyy年M月d日");
	}

	public static final Date parseCNDate2(String str) {
		String c;
		for(Iterator var1 = cnm.keySet().iterator(); var1.hasNext(); str = str.replaceAll(c, (String)cnm.get(c))) {
			c = (String)var1.next();
		}

		return parseDate(str, "yyyy年M月");
	}

	static {
		cnm.put("三十一", "31");
		cnm.put("三十", "30");
		cnm.put("二十九", "29");
		cnm.put("二十八", "28");
		cnm.put("二十七", "27");
		cnm.put("二十六", "26");
		cnm.put("二十五", "25");
		cnm.put("二十四", "24");
		cnm.put("二十三", "23");
		cnm.put("二十二", "22");
		cnm.put("二十一", "21");
		cnm.put("二十", "20");
		cnm.put("十九", "19");
		cnm.put("十八", "18");
		cnm.put("十七", "17");
		cnm.put("十六", "16");
		cnm.put("十五", "15");
		cnm.put("十四", "14");
		cnm.put("十三", "13");
		cnm.put("十二", "12");
		cnm.put("十一", "11");
		cnm.put("十", "10");
		cnm.put("九", "9");
		cnm.put("八", "8");
		cnm.put("七", "7");
		cnm.put("六", "6");
		cnm.put("五", "5");
		cnm.put("四", "4");
		cnm.put("三", "3");
		cnm.put("二", "2");
		cnm.put("一", "1");
		cnm.put("〇", "0");
	}
}
