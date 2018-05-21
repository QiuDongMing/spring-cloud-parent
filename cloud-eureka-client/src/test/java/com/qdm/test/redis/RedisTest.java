package com.qdm.test.redis;

import com.qdm.test.BaseTest;
import com.qdm.test.mongo.UserTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author qiudm
 * @date 2018/5/17 10:09
 * @desc
 */


public class RedisTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void setIf() {
        Boolean b = stringRedisTemplate.opsForValue().setIfAbsent("b", "val-b2");
        logger.error("b:{}",b);
    }


}
