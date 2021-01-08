package com.nju.test;

import com.nju.utils.ConfigProperties;
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
    //    @Value("${prefix.id}")
//    public int[] idArray;
    @Value("#{'${routerInterface.router2:}'.split(',')}")
    private String[] interface2;

    @Value("#{'${routerInterface.router3:}'.split(',')}")
    private String[] interface3;

//    @Value("${routerInterface.router}")
//    private String[] interface21;

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
//        for (int i : idArray) {
//            System.out.println(i);
//        }
        System.out.println("test");
    }

    @Autowired
    ConfigProperties configProperties;

    //    @Test
//    public void test3() {
//        System.out.println(configProperties.getInterests());
//        for (Integer i :configProperties.getInterests())
//            System.out.println(i);
//    }
    @Test
    public void test3() {
        for (int i = 0; i < configProperties.getInterfaceCommand().length; i++) {
            System.out.println("第"+i+"个" + configProperties.getInterfaceCommand()[i]);
        }
        for (int i = 0; i < configProperties.getPingCommand().length; i++) {
            System.out.println("第"+i+"个" + configProperties.getPingCommand()[i]);
        }
        for (int i = 0; i < configProperties.getStaticCommand().length; i++) {
            System.out.println("第"+i+"个" + configProperties.getStaticCommand()[i]);
        }
    }
}

