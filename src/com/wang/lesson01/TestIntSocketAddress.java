package com.wang.lesson01;

import java.net.InetSocketAddress;

/**
 * @author wang
 * @creatTime 2020/8/7
 */
public class TestIntSocketAddress {
    public static void main(String[] args) {

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(inetSocketAddress.toString());
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost", 8080);
        System.out.println(inetSocketAddress2.toString());

        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getHostName());    //地址
        System.out.println(inetSocketAddress.getPort());        //端口
    }
}
