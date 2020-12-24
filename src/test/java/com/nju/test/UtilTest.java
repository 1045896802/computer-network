package com.nju.test;

import com.nju.dao.ConfigDao;
import com.nju.service.RouterConfigService;
import com.nju.utils.TelnetUtil;
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
public class UtilTest {
    @Autowired
    private TelnetUtil telnetUtil;
    @Autowired
    private ConfigDao configDao;

    @Test
    public void configTest() {
        // telnetUtil.connect();
        String[] commands = new String[]{
                "enable"
        };
        telnetUtil.sendCommands(commands);
        System.out.println("test");
    }

    @Test
    public void test() {
        System.out.println(configDao.getAllConfig());
        System.out.println("test");
    }
}
