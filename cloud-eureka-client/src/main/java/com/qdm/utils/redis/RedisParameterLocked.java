package com.qdm.utils.redis;

import java.lang.annotation.*;

/**
 * Created by test on 2017/6/27.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisParameterLocked {

}
