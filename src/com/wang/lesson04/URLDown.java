package com.wang.lesson04;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author wang
 * @creatTime 2020/8/10
 */
public class URLDown {
    public static void main(String[] args) throws Exception {
        //1.下载地址
        URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597050462137&di=e81d42b6c04eeff13b8011bdcdb7b5e7&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D1484500186%2C1503043093%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1280%26h%3D853");

        //2.连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        //利用Path和Files简化文件的IO
        String filePath = "download_pic.jpg";
        Path path = Paths.get(filePath);
        //考虑到可能存在同名文件，先删除同名文件，再copy
        try {
            Files.delete(path);
            Files.copy(inputStream, path);
        } catch (NoSuchFileException e) {
            //不存在同名文件，会抛出NoSuchFileException，此时直接copy
            Files.copy(inputStream, path);
        }

        inputStream.close();
    }
}
