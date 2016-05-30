package com.itsp.common.util;

import java.math.BigDecimal;
import java.util.Date;

public class DateUtilTest {

	public static void main(String[] args) {
		Date date1 = DateUtil.date("2015-01-02");
		Date date2 = new Date();
		long one = date2.getTime() - date1.getTime();
		double tmp = one / 1000;
		
		System.out.println(one);
		System.out.println(tmp);
		System.out.println(tmp = tmp / 60);
		System.out.println(tmp = tmp / 60);
		
		System.out.println(tmp = tmp / 24);
		System.out.println(tmp = tmp / 365);
		
		
		BigDecimal t1 = BigDecimal.valueOf(one);  
		
		System.out.println(t1.intValue());
		
		BigDecimal t2 = BigDecimal.valueOf(365 * 24 * 60 * 60 * 1000);  
		
		System.out.println(t2.intValue());
		
		 System.out.println(t1.divide(t2,0,BigDecimal.ROUND_CEILING).doubleValue());
		 
	}

}
