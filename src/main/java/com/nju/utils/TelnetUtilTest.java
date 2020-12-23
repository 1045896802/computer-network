package com.nju.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Maxyu
 * @date 2020/12/22 11:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TelnetUtilTest {
    @Autowired
    private TelnetUtil telnetUtil;

    @Test
    public void configTest(){
        telnetUtil.connect();
        System.out.println("test");
    }
}
