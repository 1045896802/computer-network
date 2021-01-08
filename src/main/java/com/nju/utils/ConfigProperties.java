package com.nju.utils;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Maxyu
 * @date 2021/1/7 23:07
 */
@ConfigurationProperties(prefix = "router")
@Component
@ToString
@Data
public class ConfigProperties {
    public String[] interfaceCommand;
    public String[]  staticCommand;
    public String[]  pingCommand;
}
