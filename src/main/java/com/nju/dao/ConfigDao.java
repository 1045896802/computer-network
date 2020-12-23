package com.nju.dao;

import com.nju.entity.Config;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Maxyu
 * @date 2020/12/18 20:18
 */
@Mapper
public interface ConfigDao {
    /**
     * 通过路由器获取该路由器所有配置
     *
     * @param router
     * @return
     */
    List<Config> getConfigByRouter(String router);

    List<Config> getAllConfig();
}
