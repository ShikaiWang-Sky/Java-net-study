package com.wang.lesson02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 * @author wang
 * @creatTime 2020/8/7
 */
public class TCPServerDemo02 {
    public static void main(String[] args) throws Exception{
        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.监听客户端的连接
        Socket socket = serverSocket.accept();//阻塞式监听，会一直等待客户端连接
        //3.获取输入流
        InputStream is = socket.getInputStream();

        //4.文件输出，由于同名的文件存在时会抛出异常，因此先删除同名文件
        try{
            Files.delete(Paths.get("pic_receive.jpg"));
            Files.copy(is, Paths.get("pic_receive.jpg"));
        } catch (NoSuchFileException e) {
            //如果同名文件不存在，则在NoSuchFileException中直接复制
            Files.copy(is, Paths.get("pic_receive.jpg"));
        }

        //通知客户端我接收完毕了
        OutputStream os = socket.getOutputStream();
        os.write("我接收完毕了，你可以断开了".getBytes());

        is.close();
        socket.close();
        serverSocket.close();
    }
}
