package com.qdm.utils;

import org.springframework.beans.BeanUtils;

/**
 * @author qiudm
 * @date 2018/3/22 19:52
 * @desc
 */
public class BeanUtil {

    public static <T> T copy(Object poObj, Class <T>voClass)  {
        T voObj = null;
        try {
            voObj = voClass.newInstance();
            BeanUtils.copyProperties(poObj,voObj);
            return voObj;
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return voObj;
    }


}
