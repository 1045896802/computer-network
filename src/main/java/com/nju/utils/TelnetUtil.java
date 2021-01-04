package com.nju.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Maxyu
 * @date 2020/12/22 17:17
 */
@Component
public class TelnetUtil {
    /**
     * 多台设备的连接
     */
    private TelnetConnection[] telnet;

//    public TelnetUtil(@Value("${switch.ip}") String ip,
//                      @Value("${switch.port}") int port,
//                      @Value("${switch.user}") String user,
//                      @Value("${switch.password}") String password,
//                      @Value("${switch.enablePassword}") String enablePassword) {
//        try {
//            System.out.println(ip + " " + port + " " + user + " " + password);
//            System.out.println("启动Telnet...");
//            //telnet[0] = new TelnetConnection(ip, port, user, password, enablePassword);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public TelnetUtil(@Value("#{'${router.ip:}'.split(',')}") String[] ip,
                      @Value("${router.port}") int port,
                      @Value("${router.user}") String user,
                      @Value("${router.password}") String password,
                      @Value("${router.enablePassword}") String enablePassword) {
        try {
            telnet = new TelnetConnection[ip.length];
            System.out.println("启动Telnet...");
            for (int i = 0; i < ip.length; i++) {
                System.out.println(ip[i] + " " + port + " " + user + " " + password + " " + enablePassword);
                telnet[i] = new TelnetConnection(ip[i], port, user, password, enablePassword);
               // System.out.println("R"+ telnet[i].sendCommand("show ip route"));
                //telnet[i].sendCommand("enable");
                //telnet[i].readUntil("enable");
                //telnet[i].write(enablePassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendCommand(String router, String command) {
        String s = "";
        System.out.println("router:" + router + ",command:" + command);
        if ("router1".equals(router)) {
            s = telnet[0].sendCommand(command);
        } else if ("router2".equals(router)) {
            s = telnet[1].sendCommand(command);
        } else if ("router3".equals(router)) {
            s = telnet[2].sendCommand(command);
        }
        if ("router1".equals(router)) {
            s = telnet[0].sendCommand(command);
        } else if ("router2".equals(router)) {
            s = telnet[1].sendCommand(command);
        } else if ("router3".equals(router)) {
            s = telnet[2].sendCommand(command);
        }
        System.out.println(s);
        return s;
    }

    public void sendCommands(String router, String[] commands) {
        for (String command : commands) {
            System.out.println(sendCommand(router, command));
            System.out.println();
        }
    }
}
