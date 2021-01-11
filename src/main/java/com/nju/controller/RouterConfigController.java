package com.nju.controller;

import com.nju.entity.Result;
import com.nju.service.RouterConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @ApiOperation(value = "一键配置路由器静态路由")
    public Result staticRouterConfig() {
        Boolean b = routerConfigService.staticRouterConfig();
        return new Result().setSuccess(b).setData("配置静态路由成功");
    }

    @RequestMapping("/static/router{id}")
    @ApiOperation(value = "分别配置路由器静态路由")
    public Result staticRouterConfig(@PathVariable("id") Integer id) {
        Boolean b = routerConfigService.staticRouterConfig(id);
        return new Result().setSuccess(b).setData("配置router" + id + "静态路由成功");
    }

    @RequestMapping("/interface")
    @ApiOperation(value = "一键配置路由器端口")
    public Result routerInterfaceConfig() {
        Boolean b = routerConfigService.routerInterfaceConfig();
        return new Result().setSuccess(b).setData("配置路由器端口成功");
    }

    @RequestMapping("/interface/router{id}")
    @ApiOperation(value = "分别配置路由器端口")
    public Result routerInterfaceConfig(@PathVariable("id") Integer id) {
        Boolean b = routerConfigService.routerInterfaceConfig(id);
        return new Result().setSuccess(b).setData("配置路由器router" + id + "端口成功");
    }

    @RequestMapping("/ping")
    @ApiOperation(value = "测试连通性")
    public Result ping() {
        List<String> list = routerConfigService.ping();
        System.out.println(list);
        return new Result().setSuccess(true).setData(list);
    }

    @RequestMapping("/show/router{id}")
    @ApiOperation(value = "show ip route的结果")
    public Result show(@PathVariable("id") Integer id) {
        return new Result().setSuccess(true).setData(routerConfigService.show(id));
    }
}
