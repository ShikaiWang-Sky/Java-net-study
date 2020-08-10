package com.wang.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author wang
 * @creatTime 2020/8/10
 */
public class UDPSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        //准备数据：控制台读取System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String data = reader.readLine();
            byte[] dataBytes = data.getBytes();

            DatagramPacket packet = new DatagramPacket(dataBytes, 0, dataBytes.length, new InetSocketAddress("localhost", 6666));

            socket.send(packet);

            if (data.equals("bye"))
                break;
        }

        socket.close();

    }
}
