package com.qdm.task;

import com.qdm.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author qiudm
 * @date 2018/4/4 11:16
 * @desc
 */
@Component
public class SchedulerTask {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    private static final long SECOND = 1000;

    private static final long MINUTE = 1000 * 60;

    @Scheduled(fixedRate = MINUTE )
    public void testSchedulerTask() {
        logger.info("begin scheduler task, current time is:{}", TimeUtil.toTimeFormat(System.currentTimeMillis()));
    }


}
