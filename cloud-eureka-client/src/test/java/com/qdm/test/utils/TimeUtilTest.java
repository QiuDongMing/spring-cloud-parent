package com.qdm.test.utils;

import com.qdm.utils.TimeUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qiudm
 * @date 2018/4/4 14:01
 * @desc
 */
public class TimeUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(TimeUtil.class);

    @Test
    public void testFormat() {
        String dateStr = TimeUtil.toDateFormat(System.currentTimeMillis());
        String timeStr = TimeUtil.toTimeFormat(System.currentTimeMillis());
        logger.info("dataStr:{}", dateStr);
        logger.info("timeStr:{}", timeStr);
    }




}
