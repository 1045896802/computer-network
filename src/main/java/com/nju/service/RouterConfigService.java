package com.nju.service;

import java.util.List;

/**
 * @author Maxyu
 * @date 2020/12/22 19:51
 */
public interface RouterConfigService {
    /**
     * 一键配置路由器静态路由
     *
     * @return
     */
    Boolean staticRouterConfig();

    /**
     * 分别配置路由器静态路由
     *
     * @param id 路由器id
     * @return
     */
    Boolean staticRouterConfig(Integer id);

    /**
     * 一键配置路由器端口
     *
     * @return
     */
    Boolean routerInterfaceConfig();

    /**
     * 分别配置路由器端口
     *
     * @param id 路由器id
     * @return
     */
    Boolean routerInterfaceConfig(Integer id);

    /**
     * 测试连通性
     *
     * @return ping的结果
     */
    List ping();

    /**
     * show ip route的结果
     *
     * @param id 路由器id
     * @return
     */
    String show(Integer id);
}
