package com.vue.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
    /**
     * To current default date string string.
     * 현재시간을 yyyyMMddHHmmss 패턴의 String으로 리턴한다
     *
     * @return the string
     */
    public static String toCurrentDefaultDateString() {
        return toCurrentDateString("yyyyMMddHHmmss");
    }
    /**
     * To current date string string.
     * 현재시간을 입력한 패턴의 String으로 리턴한다
     *
     * @param pattern the pattern
     * @return the string
     */
    public static String toCurrentDateString(String pattern) {
        return toDateString(new Date(), pattern);
    }
    
    /**
     * To date string string.
     * 입력한 시간을 입력한 패턴의 String으로 리턴한다
     *
     * @param date    the date
     * @param pattern the pattern
     * @return the string
     */
    public static String toDateString(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
