package com.nju.service.impl;

import com.nju.service.RouterConfigService;
import com.nju.utils.AssertUtil;
import com.nju.utils.ConfigProperties;
import com.nju.utils.TelnetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    ConfigProperties configProperties;

    @Override
    public Boolean staticRouterConfig() {
        for (int i = 1; i < configProperties.getStaticCommand().length; i++) {
            log.info("配置route" + i + "静态路由");
            telnetUtil.sendCommands(i, configProperties.getStaticCommand()[i].split(","));
        }
        return true;
    }

    @Override
    public Boolean staticRouterConfig(Integer id) {
        log.info("配置route" + id + "静态路由");
        Integer[] ids = new Integer[]{1, 3};
        AssertUtil.isContainId(id, ids, "静态路由配置失败,不存在router" + id);
        telnetUtil.sendCommands(id, configProperties.getStaticCommand()[id].split(","));
        return true;
    }

    @Override
    public Boolean routerInterfaceConfig() {
        for (int i = 1; i < configProperties.getInterfaceCommand().length; i++) {
            log.info("配置route" + i + "端口");
            telnetUtil.sendCommands(i, configProperties.getInterfaceCommand()[i].split(","));
        }
        return true;
    }

    @Override
    public Boolean routerInterfaceConfig(Integer id) {
        log.info("配置route" + id + "端口");
        Integer[] ids = new Integer[]{1, 2, 3};
        AssertUtil.isContainId(id, ids, "静态路由配置失败,不存在router" + id);
        telnetUtil.sendCommands(id, configProperties.getInterfaceCommand()[id].split(","));
        return true;
    }

    @Override
    public List ping() {
        List<String> list = new ArrayList<>();
        log.info("\nRouter1 ping Router3...");
        if (telnetUtil.sendCommandByRouter1(configProperties.getPingCommand()[3]).contains("success rate is 0 percent")) {
            list.add("Router 1与Router 3" + "不通");
        }
        log.info("\nRouter3 ping Router1...");
        if (telnetUtil.sendCommandByRouter3(configProperties.getPingCommand()[1]).contains("success rate is 0 percent")) {
            list.add("Router 1与Router 3" + "不通");
        }
        if (list.size() == 0) {
            list.add("ping测试通过");
        }
        return list;
    }

    @Override
    public String show(Integer id) {
        return telnetUtil.sendCommand(id, "show ip route");
    }
}