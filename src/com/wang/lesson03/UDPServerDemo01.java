package com.wang.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author wang
 * @creatTime 2020/8/10
 */
//还要等待客户端的连接
public class UDPServerDemo01 {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet); //阻塞接收

        //关闭连接
        socket.close();

        //public String(byte[] bytes,int index,int length) 把字节数组的一部分转成字符串
        System.out.println(new String(packet.getData(), 0, packet.getData().length));
    }
}
