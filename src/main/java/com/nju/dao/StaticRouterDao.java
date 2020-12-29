package com.nju.dao;

import com.nju.entity.StaticRouter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Maxyu
 * @date 2020/12/18 20:18
 */
@Mapper
public interface StaticRouterDao {
    /**
     * 通过路由器获取该路由器所有配置
     *
     * @param router
     * @return
     */
    List<StaticRouter> getStaticRouterByRouter(String router);

    /**
     * 获取该路由器所有配置
     *
     * @return
     */
    List<StaticRouter> getAllStaticRouter();

    /**
     * 插入
     *
     * @param staticRouter
     * @return
     */
    Boolean insert(StaticRouter staticRouter);
}
