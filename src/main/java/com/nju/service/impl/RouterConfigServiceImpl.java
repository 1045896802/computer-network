package com.nju.service.impl;

import com.nju.service.RouterConfigService;
import com.nju.utils.TelnetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxyu
 * @date 2020/12/22 19:52
 */
@Service
@Slf4j
public class RouterConfigServiceImpl implements RouterConfigService {
    @Autowired
    TelnetUtil telnetUtil;

    @Value("#{'${router.ip:}'.split(',')}")
    private String[] router;

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

    @Override
    public Boolean staticRouterConfig() {
        log.info("配置route1静态路由");
        telnetUtil.sendCommandsByRouter1(static1);
        log.info("配置route2静态路由");
        telnetUtil.sendCommandsByRouter2(static2);
        log.info("配置route3静态路由");
        telnetUtil.sendCommandsByRouter3(static3);
        return true;
    }

    @Override
    public Boolean routerInterfaceConfig() {
        log.info("配置route1端口");
        telnetUtil.sendCommandsByRouter1(interface1);
        log.info("配置route2端口");
        telnetUtil.sendCommandsByRouter2(interface2);
        log.info("配置route3端口");
        telnetUtil.sendCommandsByRouter3(interface3);
        return true;
    }

    @Override
    public List ping() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < router.length; i++) {
            for (int j = 0; j < router.length; j++) {
                if (!telnetUtil.sendCommand("router" + (i + 1), "ping " + router[j]).contains("100 percent")) {
                    list.add("Router " + (i + 1) + "与Router " + (j + 1) + "不通");
                }
            }
        }
        if (list.size() == 0) {
            list.add("ping测试通过");
        }
        return list;
    }
}