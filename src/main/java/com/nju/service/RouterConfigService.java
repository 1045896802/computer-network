package com.nju.service;

import com.nju.entity.RouterInterface;
import com.nju.entity.StaticRouter;

import java.util.List;

/**
 * @author Maxyu
 * @date 2020/12/22 19:51
 */
public interface RouterConfigService {
    /**
     * 通过路由器名获得配置
     *
     * @param router
     * @return
     */
    List getConfigByRouter(String router);

    /**
     * 获得所有路由器配置
     *
     * @return
     */
    List getAllConfig();


    /**
     * 配置路由器静态路由
     *
     * @param staticRouter
     * @return
     */
    Boolean staticRouterConfig(StaticRouter staticRouter);

    /**
     * 配置路由器端口
     *
     * @param routerInterface
     * @return
     */
    Boolean routerInterfaceConfig(RouterInterface routerInterface);

    /**
     * 测试连通性
     *
     * @return ping的结果
     */
    List ping();
}
