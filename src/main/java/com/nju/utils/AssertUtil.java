package com.nju.utils;

import java.util.Arrays;

/**
 * @author Maxyu
 * @date 2021/1/8 10:27
 */
public class AssertUtil {
    /**
     * 判断ids是否包含id,不包含则抛出异常
     *
     * @param id
     * @param ids
     * @param message 异常信息
     */
    public static void isContainId(Integer id, Integer[] ids, String message) {
        if (!Arrays.asList(ids).contains(id)) {
            throw new RuntimeException(message);
        }
    }
}
