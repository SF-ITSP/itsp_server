package com.itsp.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String HH_MM = "HH:mm";

	public static String string(Date date) {
		if (date == null || "".equals(date))
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
		return sdf.format(date);
	}

	public static String string(Date date, String format) {
		if (date == null || "".equals(date))
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date date(String s) {
		Date date = new Date();
		if (s != null && !"".equals(s)) {
			String t = s.replaceAll("[^0-9]", "");
			while (t.length() < YYYYMMDDHHMMSS.length()) {
				t = t + "0";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMMSS);
			try {
				date = sdf.parse(t);
			} catch (Exception e) {
			}
		}
		return date;
	}

	public static int getDateLength(String fromDate, String toDate) {
		Calendar c1 = getCal(fromDate);
		Calendar c2 = getCal(toDate);
		int[] p1 = { c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DAY_OF_MONTH) };
		int[] p2 = { c2.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH) };
		return p2[0] - p1[0];
	}

	public static Calendar getCal(String date) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1,
				Integer.parseInt(date.substring(6, 8)));
		return cal;
	}
}
