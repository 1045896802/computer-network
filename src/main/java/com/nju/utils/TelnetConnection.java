package com.nju.utils;

import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;

/**
 * @author Maxyu
 * @date 2020/12/17 15:45
 */
public class TelnetConnection {
    private TelnetClient telnet = new TelnetClient();
    private InputStream in;
    private PrintStream out;
    private char prompt = '>';

    /**
     * 普通用户登录
     *
     * @param ip
     * @param port
     * @param user
     * @param password
     */
    public TelnetConnection(String ip, int port, String user, String password, String enablePassword) {
        try {
            telnet.connect(ip, port);
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());
            // 根据root用户设置结束符
            this.prompt = user.equals("root") ? '#' : '>';
            System.out.println(this.prompt);
            login(user, password, enablePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录
     *
     * @param user
     * @param password
     * @param enablePassword
     */
    public void login(String user, String password, String enablePassword) {
//        readUntil("login:");
//        write(user);
//        readUntil("Password:");
//        write(password);
//        readUntil(prompt + " ");
        readUntil("Password:");
        write(password);
        write("enable");
        readUntil("Password:");
        write(enablePassword);
        this.prompt = '#';
        //System.out.println();
        // System.out.println("ip:"+sendCommand("")+sendCommand("show ip route"));
        //System.out.println();
    }

    /**
     * 读取分析结果
     *
     * @param pattern
     * @return
     */
    public String readUntil(String pattern) {
        try {
            char lastChar = pattern.charAt(pattern.length() - 1);
            StringBuffer sb = new StringBuffer();
            char ch = (char) in.read();
            while (true) {
                sb.append(ch);
                if (ch == lastChar) {
                    if (sb.toString().endsWith(pattern)) {
                        return sb.toString();
                    }
                }
                ch = (char) in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写操作
     *
     * @param value
     */
    public void write(String value) {
        try {
            out.println(value);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 向目标发送命令字符串
     *
     * @param command
     * @return
     */
    public String sendCommand(String command) {
        try {
            write(command);
            //return readUntil(prompt + " ");
            return readUntil(prompt + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接
     */
    public void disconnect() {
        try {
            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("启动Telnet...");
            String ip = "172.19.240.90";
            int port = 23;
            String user = "root";
            String password = "19980925";
            String enablePassword = "19980925";
            TelnetConnection telnet = new TelnetConnection(ip, port, user, password, enablePassword);
            telnet.sendCommand("export LANG=en");
            String r1 = telnet.sendCommand("cd /home/project/");
            String r3 = telnet.sendCommand("ifconfig");
            System.out.println("显示结果");
            System.out.println("r1" + r1);
            System.out.println("???");
            System.out.println("r3" + r3);
            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
