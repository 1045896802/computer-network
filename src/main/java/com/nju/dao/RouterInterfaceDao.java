package com.nju.dao;

import com.nju.entity.RouterInterface;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Maxyu
 * @date 2020/12/25 11:20
 */
@Mapper
public interface RouterInterfaceDao {
    /**
     * 通过路由器名称获取该路由器所有配置
     *
     * @param router
     * @return
     */
    List<RouterInterface> getRouterInterfaceByRouter(String router);

    /**
     * 获取该路由器所有配置
     *
     * @return
     */
    List<RouterInterface> getAllRouterInterface();

    /**
     * 插入
     *
     * @param routerInterface
     * @return
     */
    Boolean insert(RouterInterface routerInterface);
}
