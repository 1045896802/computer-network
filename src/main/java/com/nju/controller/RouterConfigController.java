package com.nju.controller;

import com.nju.entity.Result;
import com.nju.service.RouterConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Maxyu
 * @date 2020/12/17 14:24
 */
@RestController
public class RouterConfigController {
    @Autowired
    RouterConfigService routerConfigService;

    @RequestMapping("/static")
    public Result staticRouterConfig() {
        Boolean b = routerConfigService.staticRouterConfig();
        return new Result().setSuccess(b);
    }

    @RequestMapping("/interface")
    public Result routerInterfaceConfig() {
        Boolean b = routerConfigService.routerInterfaceConfig();
        return new Result().setSuccess(b);
    }

    @RequestMapping("/ping")
    public Result ping() {
        List<String> list = routerConfigService.ping();
        System.out.println(list);
        return new Result().setSuccess(true).setData(list);
    }
}
