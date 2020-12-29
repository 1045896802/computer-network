package com.nju.test;

import com.nju.dao.RouterInterfaceDao;
import com.nju.dao.StaticRouterDao;
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
    //@Autowired
    //private TelnetUtil telnetUtil;
    @Autowired
    private StaticRouterDao staticRouterDao;

    @Test
    public void configTest() {
        // telnetUtil.connect();
//        String[] commands = new String[]{
//                "ifconfig"
//        };
//        telnetUtil.sendCommands(commands);
//        System.out.println("test");
    }

    @Test
    public void test() {
        System.out.println(staticRouterDao.getAllStaticRouter());
        System.out.println("test");
    }

    @Autowired
    RouterInterfaceDao routerInterfaceDao;

    @Test
    public void test1() {
        System.out.println(routerInterfaceDao.getAllRouterInterface());
        System.out.println("test");
    }
}
