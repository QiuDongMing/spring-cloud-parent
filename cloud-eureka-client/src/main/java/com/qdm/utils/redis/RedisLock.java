package com.qdm.utils.redis;

import java.lang.annotation.*;

/**
 * @author qiudm
 * @date 2018/3/30 9:20
 * @desc
 */
//@Inherited：允许子类继承父类的注解。@see https://blog.csdn.net/zmx729618/article/details/78060333
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisLock {

    String key();

    long expireTime() default 60;

    String msg() default "获取锁失败";

}
