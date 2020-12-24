package com.nju.controller;

import com.nju.entity.Config;
import com.nju.entity.Result;
import com.nju.service.RouterConfigService;
import com.nju.utils.TelnetUtil;
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
    @Autowired
    TelnetUtil telnetUtil;

    @RequestMapping("/getConfig")
    public Result getConfig(String router) {
        List<Config> list = routerConfigService.getConfigByRouter(router);
        return new Result().setSuccess(true).setData(list);
    }

    @RequestMapping("/getAllConfig")
    public Result getAllConfig() {
        List<Config> list = routerConfigService.getAllConfig();
        return new Result().setSuccess(true).setData(list);
    }

    @RequestMapping("/routerConfig")
    public Result routerConfig(Config config) {
//        Boolean b = routerConfigService.routerConfig(config);
//        return new Result().setSuccess(b);
        System.out.println(config);
        System.out.println("222");
        return new Result().setData(config);
    }

    @RequestMapping("/ping")
    public Result ping() {
        System.out.println("123456");
        List<String> list = routerConfigService.ping();
        return new Result().setSuccess(true).setData(list);
    }

    @RequestMapping("/test")
    public Result test() {
        System.out.println("123456");
        String s = telnetUtil.sendCommand("telnet 172.16.0.2");
        telnetUtil.sendCommand("123456");
        return new Result().setSuccess(true).setData(s);
    }
}
