package com.wang.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author wang
 * @creatTime 2020/8/7
 */
public class TCPClientDemo02 {
    public static void main(String[] args) throws Exception{
        //1. 创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("localhost"), 9999);
        //2. 创建一个输出流
        OutputStream os = socket.getOutputStream();

        //文件流 Files用copy写到输入输出流，用readAllXXX读进来
        //3. 读取文件
        Path filePath = Paths.get("pic.jpg");

        //4. 写出文件
        Files.copy(filePath, os);

        //通知服务器，我已经结束了
        socket.shutdownOutput();    //我已经传输完了

        //确定服务器接收完毕，才能断开连接
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            baos.write(buffer,0,len);
        }

        System.out.println(baos.toString());

        //5.关闭资源
        baos.close();
        inputStream.close();
        os.close();
        socket.close();
    }
}
