package com.nju.controller;

import com.nju.entity.RouterInterface;
import com.nju.entity.StaticRouter;
import com.nju.entity.Result;
import com.nju.service.RouterConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxyu
 * @date 2020/12/17 14:24
 */
@RestController
public class RouterConfigController {
    @Autowired
    RouterConfigService routerConfigService;

    @RequestMapping("/getConfig")
    public Result getConfig(String router) {
        List<StaticRouter> list = routerConfigService.getConfigByRouter(router);
        return new Result().setSuccess(true).setData(list);
    }

    @RequestMapping("/init")
    public Result init() {
        List<StaticRouter> list = routerConfigService.getAllConfig();
        return new Result().setSuccess(true).setData(list);
    }

    @RequestMapping("/static")
    public Result staticRouterConfig(StaticRouter staticRouter) {
        System.out.println(staticRouter);
        Boolean b = routerConfigService.staticRouterConfig(staticRouter);
        //Boolean b = true;
        return new Result().setSuccess(b);
    }

    @RequestMapping("/interface")
    public Result routerInterfaceConfig(RouterInterface routerInterface) {
        System.out.println(routerInterface);
        Boolean b = routerConfigService.routerInterfaceConfig(routerInterface);
        return new Result().setSuccess(b);
    }

    @RequestMapping("/ping")
    public Result ping() {
        List<String> list = routerConfigService.ping();
//        List<String> list = new ArrayList<>();
//        list.add("111");
//        list.add("222");
        System.out.println(list);
        return new Result().setSuccess(true).setData(list);
    }
}
