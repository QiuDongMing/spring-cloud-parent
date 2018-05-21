package com.qdm.mq.conf;

import com.jayway.jsonpath.internal.Utils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.*;

/**
 * @author qiudm
 * @date 2018/5/11 18:58
 * @desc
 */
@Configuration
public class MqConfig implements EnvironmentAware {


    private static Logger logger = LoggerFactory.getLogger(MqConfig.class);
    private static Environment env = null;
    private static Map<String, String> properties = new HashMap(32);

    public MqConfig() {
    }

    public static boolean isEnable(String instanceName) {
        return hasKey(instanceName, "mq.host") || hasKey(instanceName, "mq.addresses");
    }

    public static String getApplicationName() {
        return getString("", "spring.application.name", "");
    }

    public static String getAddresses(String instanceName) {
        return getString(instanceName, "mq.addresses", "");
    }

    public static String getHost(String instanceName) {
        return getString(instanceName, "mq.host", "127.0.0.1");
    }

    public static int getPort(String instanceName) {
        return getInt(instanceName, "mq.port", 6379);
    }

    public static String getUsername(String instanceName) {
        return getString(instanceName, "mq.username", "");
    }

    public static String getPassword(String instanceName) {
        return getString(instanceName, "mq.password", "");
    }

    public static String getVirtualHost(String instanceName) {
        return getString(instanceName, "mq.virtual.host", "/");
    }

    public static int getConnectionTimeout(String instanceName) {
        return getInt(instanceName, "mq.connect.timeout", 20000);
    }

    public static int getRequstHeartbeat(String instanceName) {
        return getInt(instanceName, "mq.request.heartbeat", 60);
    }

    public static String getString(String instanceName, String key, String defaultValue) {
        String newKey = rebuildKey(instanceName, key);
        String value = (String)properties.get(newKey);
        if(value != null) {
            return value;
        } else {
            if(env != null) {
                value = env.getProperty(newKey, defaultValue);
                if(StringUtils.isNotEmpty(value)) {
                    properties.put(newKey, value);
                    return value;
                }
            }

            return defaultValue;
        }
    }

    public static int getInt(String instanceName, String key, int defaultValue) {
        return Integer.parseInt(getString(instanceName, key, String.valueOf(defaultValue)));
    }

    public static Long getLongValue(String instanceName, String key, long defaultValue) {
        return Long.valueOf(Long.parseLong(getString(instanceName, key, String.valueOf(defaultValue))));
    }

    public static boolean getBoolean(String instanceName, String key, boolean defaultValue) {
        return Boolean.parseBoolean(getString(instanceName, key, String.valueOf(defaultValue)));
    }

    public static int getWorkerId() {
        return getInt("", "server.workid", 60);
    }

    public void setEnvironment(Environment environment) {
        env = environment;
    }

    public static synchronized void loadProperties(Properties pro) {
        if(pro != null) {
            Set entrySet = pro.entrySet();
            Iterator var2 = entrySet.iterator();

            while(var2.hasNext()) {
                Map.Entry entry = (Map.Entry)var2.next();
                Object value = entry.getValue();
                if(value != null && !"".equals(value)) {
                    logger.info("load Properties:[{}={}]", entry.getKey(), value);
                    properties.put(entry.getKey().toString(), value.toString());
                }
            }
        }

    }

    private static boolean hasKey(String instanceName, String key) {
        String newKey = rebuildKey(instanceName, key);
        String value = (String)properties.get(newKey);
        if(StringUtils.isNotBlank(value)) {
            return true;
        } else {
            if(env != null) {
                value = env.getProperty(newKey);
                if(StringUtils.isNotBlank(value)) {
                    return true;
                }
            }

            return false;
        }
    }

    private static String rebuildKey(String instanceName, String key) {
        return Utils.isEmpty(instanceName)?key:instanceName + "." + key;
    }


}
