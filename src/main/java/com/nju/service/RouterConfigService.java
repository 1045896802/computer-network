package com.nju.service;

import com.nju.entity.Config;

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
     * 配置路由器
     *
     * @param config
     * @return
     */
    Boolean routerConfig(Config config);

    /**
     * 测试连通性
     *
     * @return ping的结果
     */
    List ping();
}
