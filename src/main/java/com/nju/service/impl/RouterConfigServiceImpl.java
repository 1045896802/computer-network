package com.nju.service.impl;

import com.nju.dao.ConfigDao;
import com.nju.entity.Config;
import com.nju.service.RouterConfigService;
import com.nju.utils.TelnetUtil;
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
public class RouterConfigServiceImpl implements RouterConfigService {
    @Autowired
    ConfigDao configDao;
    @Autowired
    TelnetUtil telnetUtil;

    @Value("#{'${router.ip:}'.split(',')}")
    private String[] router;

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
    public List ping() {
        //String[] commands=new String[router.length];
        List<String> list = new ArrayList<>();

        //router1测试
//        commands = new String[]{
//                "telnet " + router1,
//                "ping " + router2,
//                "ping " + router3
//        };

        for (int i = 0; i < router.length; i++) {
            telnetUtil.sendCommand("telnet " + router[i]);
            for (int j = 0; j < router.length; j++) {
                if (!telnetUtil.sendCommand("ping " + router[j]).contains("100 percent")) {
                    list.add("Router " + i + "与Router " + j + "不通");
                }
            }
        }
        if (list.size() == 0) {
            list.add("ping测试通过");
        }
        return list;
    }
}