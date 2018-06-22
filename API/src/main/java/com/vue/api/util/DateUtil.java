package com.vue.api.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    

    /**
     *  LocalDateTime의 변수를 받아 String인 yyyy-MM-dd HH:mm:ss 형태의 값을 넘겨준다. 
     */
    public static String localDateTimeToStrDetail(LocalDateTime date) {
    	return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    /**
     *  LocalDateTime의 변수를 받아 String의 원하는 패턴 형태로 넘겨준다. 
     */
    public static String localDateTimeToStrPattern(LocalDateTime date, String pattern) {
    	return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}
