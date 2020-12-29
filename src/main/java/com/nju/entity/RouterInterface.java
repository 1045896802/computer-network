package com.nju.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Maxyu
 * @date 2020/12/25 11:00
 */
@Getter
@Setter
@ToString
public class RouterInterface {
    /**
     * 路由器名称
     */
    String router;
    /**
     * 配置的端口
     */
    String port;
    /**
     * 配置的ip地址
     */
    String ip;
    /**
     * 配置的子网掩码
     */
    String mask;
}
