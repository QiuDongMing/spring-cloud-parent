package com.qdm.demo1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;


/**
 * @author qiudm
 * @date 2018/3/23 14:13
 * @desc
 */
public class JsonMethods {

    @Test
    public void jsonArr() {
        String str = "[{\"name\":\"zhangsan\"},{\"name\":\"lisi\"}]";
        JSONArray jsonArray = JSON.parseArray(str);
        Object o;
        for (int i = 0; i < jsonArray.size(); i++) {
            o = jsonArray.get(i);
        }
    }


}
