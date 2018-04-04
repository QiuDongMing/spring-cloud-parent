package com.qdm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * @author qiudm
 * @date 2018/4/4 13:52
 * @desc
 */
public class TimeUtil {

    private static final Logger logger = LoggerFactory.getLogger(TimeUtil.class);

    private static final String DateFormat = "yyyy-MM-dd";

    private static final String TimeFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式yyyy-MM-dd
     * @param time
     * @return
     */
    public static String toDateFormat(long time) {
        return format(time, DateFormat);
    }

    /**
     * 时间格式yyyy-MM-dd HH:mm:ss
     * @param time
     * @return
     */
    public static String toTimeFormat(long time) {
        return format(time, TimeFormat);
    }

    public static String format(long time, String formatRex) {
        String timeStr = null;
        try {
            timeStr = new SimpleDateFormat(formatRex).format(time);
        } catch (Exception e) {
            logger.error("error convert time:{}, to format like :{}", time, formatRex);
        }
        return timeStr;
    }


}
