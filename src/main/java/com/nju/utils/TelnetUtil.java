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

    public TelnetUtil(@Value("${switch.ip}") String ip,
                      @Value("${switch.port}") int port,
                      @Value("${switch.user}") String user,
                      @Value("${switch.password}") String password,
                      @Value("${switch.enablePassword}") String enablePassword) {
        try {
            System.out.println(ip + " " + port + " " + user + " " + password);
            System.out.println("启动Telnet...");
            //telnet[0] = new TelnetConnection(ip, port, user, password, enablePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public TelnetUtil(@Value("#{'${router.ip:}'.split(',')}") String[] ip,
//                      @Value("${router.port}") int port,
//                      @Value("${router.user}") String user,
//                      @Value("${router.password}") String password,
//                      @Value("${router.enablePassword}") String enablePassword) {
//        try {
//            telnet = new TelnetConnection[ip.length + 1];
//            System.out.println("启动Telnet...");
//            for (int i = 1; i <= ip.length; i++) {
//                System.out.println(ip[i] + " " + port + " " + user + " " + password + " " + enablePassword);
//                telnet[i] = new TelnetConnection(ip[i - 1], port, user, password, enablePassword);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public String sendCommand(Integer routerId, String command) {
        String s = "";
        System.out.println("router:" + routerId + ",command:" + command);
        if (routerId == 1) {
            telnet[0].sendCommand(command);
            s = telnet[0].sendCommand(command);
        } else if (routerId == 2) {
            telnet[1].sendCommand(command);
            s = telnet[1].sendCommand(command);
        } else if (routerId == 3) {
            telnet[2].sendCommand(command);
            s = telnet[2].sendCommand(command);
        }
        System.out.println(s);
        return s;
    }

    public void sendCommandsByRouter1(String[] commands) {
        for (String command : commands) {
            System.out.println(sendCommandByRouter1(command));
            System.out.println();
        }
    }

    public void sendCommandsByRouter2(String[] commands) {
        for (String command : commands) {
            System.out.println(sendCommandByRouter2(command));
            System.out.println();
        }
    }

    public void sendCommandsByRouter3(String[] commands) {
        for (String command : commands) {
            System.out.println(sendCommandByRouter3(command));
            System.out.println();
        }
    }

    public String sendCommandByRouter1(String command) {
        String s = "";
        telnet[0].sendCommand(command);
        s = telnet[0].sendCommand(command);
        System.out.println(s);
        return s;
    }

    public String sendCommandByRouter2(String command) {
        String s = "";
        telnet[1].sendCommand(command);
        s = telnet[1].sendCommand(command);
        System.out.println(s);
        return s;
    }

    public String sendCommandByRouter3(String command) {
        String s = "";
        telnet[2].sendCommand(command);
        s = telnet[2].sendCommand(command);
        System.out.println(s);
        return s;
    }

    public void sendCommands(Integer routerId, String[] commands) {
        for (String command : commands) {
            System.out.println(sendCommand(routerId, command));
            System.out.println();
        }
    }
}
