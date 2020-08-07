package com.wang.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author wang
 * @creatTime 2020/8/7
 */
//客户端
public class TCPClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.要知道服务器的地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            //2. 端口号
            int port = 9999;
            //3. 创建一个socket连接
            socket = new Socket(serverIP, port);
            //4. 发送消息IO流
            os = socket.getOutputStream();
            os.write("这是一行字".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
