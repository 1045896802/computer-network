package com.nju.service.impl;

import com.nju.dao.RouterInterfaceDao;
import com.nju.dao.StaticRouterDao;
import com.nju.entity.RouterInterface;
import com.nju.entity.StaticRouter;
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
    StaticRouterDao staticRouterDao;
    @Autowired
    RouterInterfaceDao routerInterfaceDao;

    @Autowired
    TelnetUtil telnetUtil;

    @Value("#{'${router.ip:}'.split(',')}")
    private String[] router;

    @Override
    public List getConfigByRouter(String router) {
        List<StaticRouter> list = staticRouterDao.getStaticRouterByRouter(router);
        return list;
    }

    @Override
    public List getAllConfig() {
        List<StaticRouter> list = staticRouterDao.getAllStaticRouter();
        return list;
    }

    @Override
    public Boolean staticRouterConfig(StaticRouter staticRouter) {
        String[] commands = new String[]{
                "conf t",
                "ip route " + staticRouter.getIp() + " " + staticRouter.getMask() + " " + staticRouter.getNextHop()
        };
        telnetUtil.sendCommands(staticRouter.getRouter(), commands);
        staticRouterDao.insert(staticRouter);
        return true;
    }

    @Override
    public Boolean routerInterfaceConfig(RouterInterface routerInterface) {
        String[] commands = new String[]{
                "conf t",
                "int " + routerInterface.getPort(),
                "ip add " + routerInterface.getIp() + " " + routerInterface.getMask(),
                "no shutdown"
        };
        telnetUtil.sendCommands(routerInterface.getRouter(), commands);
        routerInterfaceDao.insert(routerInterface);
        return true;
    }

    @Override
    public List ping() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < router.length; i++) {
            for (int j = 0; j < router.length; j++) {
                if (!telnetUtil.sendCommand("router" + (i + 1), "ping " + router[j]).contains("100 percent")) {
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