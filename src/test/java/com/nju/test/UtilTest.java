package com.nju.test;

import com.nju.dao.RouterInterfaceDao;
import com.nju.dao.StaticRouterDao;
import com.nju.utils.TelnetUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Maxyu
 * @date 2020/12/22 11:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UtilTest {
    @Autowired
    private TelnetUtil telnetUtil;
    @Autowired
    private StaticRouterDao staticRouterDao;

    @Value("#{'${routerInterface.router1:}'.split(',')}")
    private String[] interface1;

    @Value("#{'${routerInterface.router2:}'.split(',')}")
    private String[] interface2;

    @Value("#{'${routerInterface.router3:}'.split(',')}")
    private String[] interface3;

    @Value("#{'${staticRouter.router1:}'.split(',')}")
    private String[] static1;

    @Value("#{'${staticRouter.router2:}'.split(',')}")
    private String[] static2;

    @Value("#{'${staticRouter.router3:}'.split(',')}")
    private String[] static3;

    @Test
    public void configTest() {
        System.out.println("test");
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

    @Test
    public void test2() {
        for (String c : interface1) {
            System.out.println(c);
        }
        for (String c : interface2) {
            System.out.println(c);
        }
        for (String c : interface3) {
            System.out.println(c);
        }
        for (String c : static1) {
            System.out.println(c);
        }
        for (String c : static2) {
            System.out.println(c);
        }
        for (String c : static3) {
            System.out.println(c);
        }
        System.out.println("test");
    }
}

