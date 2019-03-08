package com.example.commoncore.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具类
 */
public class DateUtils {

    public static Date doParse(String date){
        DateFormat dateFormat = new SimpleDateFormat();
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
