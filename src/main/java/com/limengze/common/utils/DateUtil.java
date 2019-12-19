package com.limengze.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *	@author lmz
 *	
 *	@time 2019年12月19日
 */
public class DateUtil {
	/*
	* 方法1：(10分)
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	public static Date getDateByInitMonth(Date src){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		calendar.set(calendar.HOUR,0);
		calendar.set(calendar.MINUTE,0);
		calendar.set(calendar.SECOND,0);
		return calendar.getTime();
	
	}
	
	
	/*
	* 方法2：(10分)
	* 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	public static Date getDateByFullMonth(Date src){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		int month = calendar.get(Calendar.MONTH);
		String str1 = "1,3,5,7,8,10,12";
		if (str1.contains(month+"")) {
			calendar.set(Calendar.DAY_OF_MONTH, 31);
		}if (month==2) {
			calendar.set(Calendar.DAY_OF_MONTH, 29);
		} else {
			calendar.set(Calendar.DAY_OF_MONTH, 30);
		}
		calendar.set(calendar.HOUR,23);
		calendar.set(calendar.MINUTE,59);
		calendar.set(calendar.SECOND,59);
		return src;
	}
}
