package com.wang.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author wang
 * @creatTime 2020/8/10
 */
public class TalkReceive implements Runnable {
    DatagramSocket socket = null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                //准备接收包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);

                socket.receive(packet); //阻塞式接收包裹

                //当接收到"bye"，断开连接
                byte[] data = packet.getData();
                String receiveData = new String(data, 0, data.length);
                System.out.println(msgFrom + "：" + receiveData);
                if ("bye".equals(receiveData)) {
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();
    }
}
