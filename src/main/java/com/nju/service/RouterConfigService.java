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
     * 配置路由器静态路由
     *
     * @return
     */
    Boolean staticRouterConfig();

    /**
     * 配置路由器端口
     *
     * @return
     */
    Boolean routerInterfaceConfig();

    /**
     * 测试连通性
     *
     * @return ping的结果
     */
    List ping();
}
