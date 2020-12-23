package com.nju.service.impl;

import com.nju.dao.ConfigDao;
import com.nju.entity.Config;
import com.nju.service.RouterConfigService;
import com.nju.utils.TelnetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Maxyu
 * @date 2020/12/22 19:52
 */
@Service
public class RouterConfigServiceImpl implements RouterConfigService {
    @Autowired
    ConfigDao configDao;
    @Autowired
    TelnetUtil telnetUtil;

    @Override
    public List getConfigByRouter(String router) {
        List<Config> list = configDao.getConfigByRouter(router);
        return list;
    }

    @Override
    public List getAllConfig() {
        List<Config> list = configDao.getAllConfig();
        return list;
    }

    @Override
    public Boolean routerConfig(Config config) {
        String[] commands = new String[]{
                "telnet " + config.getRouter(),
                "enable",
                "conf t",
                "ip route " + config.getIp() + " " + config.getMask() + " " + config.getNextHop()
        };
        telnetUtil.sendCommands(commands);
        return true;
    }

    @Override
    public Boolean ping() {
        String[] commands;
        String r1 = "1", r2 = "2", r3 = "3";

        //R1测试
        commands = new String[]{
                "telnet " + r1,
                "ping " + r2,
                "ping " + r3
        };
        telnetUtil.sendCommands(commands);

        //R2测试
         commands = new String[]{
                "telnet " + r2,
                "ping " + r1,
                "ping " + r3
        };
        telnetUtil.sendCommands(commands);

        //R3测试
        commands = new String[]{
                "telnet " + r3,
                "ping " + r1,
                "ping " + r2
        };
        telnetUtil.sendCommands(commands);
        return true;
    }
}
