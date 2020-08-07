package com.wang.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wang
 * @creatTime 2020/8/7
 */
//测试IP
public class Test01 {
    public static void main(String[] args) {
        //快捷键 clt+alt+t
        try {
            //查询本机地址
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress3 = InetAddress.getByName("localhost");
            System.out.println(inetAddress3);
            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4);

            //查询网站IP地址
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            //常用方法
            //System.out.println(inetAddress2.getAddress());
            System.out.println(inetAddress2.getCanonicalHostName());    //规范的名字
            System.out.println(inetAddress2.getHostAddress());          //ip
            System.out.println(inetAddress2.getHostName());             //域名，或者本机的名字

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
