package com.qdm.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/3/28 14:07
 * @desc
 */
public class MapConvertUtil {

    public static Map<String, Object> PO2Map(Object o) throws Exception{
        Field[] fields = o.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>(fields.length);
        for (Field field : fields) {
            field.setAccessible(true);
            String proName = field.getName();
            Object proValue = field.get(o);
            if (Objects.nonNull(proValue)){
                map.put(proName, proValue);
            }
        }
        return map;
    }


    public static <T> T map2PO(Map<String,Object> map,Class<T> cls) throws Exception{
        T t = null;
        if (!map.isEmpty()) {
            t = cls.newInstance();
            for (Map.Entry entry:map.entrySet()){
                Field[] fields = cls.getDeclaredFields();
                for (Field field : fields) {
                    int mod = field.getModifiers();
                    if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                        continue;
                    }
                    if (field.getName().equals(entry.getKey())) {
                        field.setAccessible(true);
                        field.set(t, entry.getValue());
                    }
                }
            }
        }
        return t;
    }
}
