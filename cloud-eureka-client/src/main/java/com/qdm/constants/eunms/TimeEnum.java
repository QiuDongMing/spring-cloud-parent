package com.qdm.constants.eunms;

/**
 * @author qiudm
 * @date 2018/4/4 11:48
 * @desc
 */
public enum TimeEnum {
    /**
     * 秒
     */
    SECOND(1000),
    /**
     * 分
     */
    MINUTE(1000 * 60),
    /**
     *时
     */
    HOUR(1000 * 60 * 60),

    /**
     * 天
     */
    DAY(1000 * 60 * 60 * 24),
    /**
     * 年
     */
    YEAR(1000 * 60 * 60 * 24 * 365);

    private long time;

    TimeEnum(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}
