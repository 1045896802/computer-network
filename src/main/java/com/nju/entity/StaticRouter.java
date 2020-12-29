package com.nju.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Maxyu
 * @date 2020/12/18 20:13
 */
@Getter
@Setter
@ToString
public class StaticRouter {
    /**
     * 路由器名称
     */
    String router;
    /**
     * 配置的ip地址
     */
    String ip;
    /**
     * 配置的子网掩码
     */
    String mask;
    /**
     * 下一跳地址
     */
    String nextHop;
}
