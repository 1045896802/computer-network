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
    private TelnetConnection telnet;

    public TelnetUtil(@Value("${switch.ip}") String ip,
                      @Value("${switch.port}") int port,
                      @Value("${switch.user}") String user,
                      @Value("${switch.password}") String password) {
        try {
            System.out.println(ip + " " + port + " " + user + " " + password);
            System.out.println("启动Telnet...");
            telnet = new TelnetConnection(ip, port, user, password);
            telnet.sendCommand("export LANG=en");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    public void connect() {
//        try {
//            System.out.println(ip + " " + port + " " + user + " " + password);
//            System.out.println("启动Telnet...");
//            telnet = new TelnetConnection(ip, port, user, password);
//            telnet.sendCommand("export LANG=en");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public String sendCommand(String command) {
        telnet.sendCommand("export LANG=en");
        String s = telnet.sendCommand(command);
        return s;
    }

    public void sendCommands(String[] commands) {
        telnet.sendCommand("export LANG=en");
        for (String command : commands) {
            System.out.println(telnet.sendCommand(command));
            System.out.println();
        }
    }
}
