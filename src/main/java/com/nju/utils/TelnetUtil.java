package com.nju.utils;

import com.nju.entity.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Maxyu
 * @date 2020/12/22 17:17
 */
@Component
public class TelnetUtil {
    @Value("${switch.ip}")
    private String ip;

    @Value("${switch.port}")
    private int port;

    @Value("${switch.user}")
    private String user;

    @Value("${switch.password}")
    private String password;

    private TelnetConnection telnet;

    public TelnetUtil() {
        try {
            System.out.println("启动Telnet...");
            telnet = new TelnetConnection(ip, port, user, password);
            telnet.sendCommand("export LANG=en");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendCommands(String[] commands) {
        telnet.sendCommand("export LANG=en");
        for (String command : commands) {
            System.out.println(telnet.sendCommand(command));
        }
    }
}
