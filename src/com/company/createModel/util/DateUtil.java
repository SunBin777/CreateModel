package com.company.createModel.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 孙斌
 * @date 2020-10-2020/10/30 10:48
 * 时间处理类
 */
public class DateUtil {

    /**
     * 格式化日期 ：yyyy-MM-dd HH:mm:ss SSS
     *
     * @param date
     * @return String
     */
    public static String SimpleDateFormatDate(Date date) {
        if (date == null) return "";
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(date);
    }

    /**
     * 格式化日期 ：yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return String
     */
    public static String SimpleDateFormatDateNoSSS(Date date) {
        if (date == null) return "";
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    /**
     * 格式化日期 ：yyyy-MM-dd
     *
     * @param date
     * @return String
     */
    public static String SimpleDateFormatDateNoHH(Date date) {
        if (date == null) return "";
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
