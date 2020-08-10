package com.wang.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author wang
 * @creatTime 2020/8/10
 */
public class TalkSend implements Runnable {

    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int fromPort;
    private String toIP;
    private int toPort;

    public TalkSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        //准备数据：控制台读取System.in
        while (true) {
            try {
                String data = reader.readLine();
                byte[] dataBytes = data.getBytes();

                DatagramPacket packet = new DatagramPacket(dataBytes, 0, dataBytes.length, new InetSocketAddress(this.toIP, this.toPort));

                socket.send(packet);

                if ("bye".equals(data)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        socket.close();

    }
}
