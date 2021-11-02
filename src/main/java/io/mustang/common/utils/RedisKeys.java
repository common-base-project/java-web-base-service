package io.mustang.common.utils;

/**
 * Redis所有Keys
 *
 * @author Mustang
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
