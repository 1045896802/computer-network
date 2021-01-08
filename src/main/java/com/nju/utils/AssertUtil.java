package com.nju.utils;

import java.util.Arrays;

/**
 * @author Maxyu
 * @date 2021/1/8 10:27
 */
public class AssertUtil {
    public static void isContainId(Integer id, Integer[] ids, String message) {
        if (!Arrays.asList(ids).contains(id)) {
            throw new RuntimeException(message);
        }
    }
}
