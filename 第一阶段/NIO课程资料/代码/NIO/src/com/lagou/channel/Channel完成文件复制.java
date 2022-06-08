package com.lagou.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Channel完成文件复制 {

    /**
     * 需求：将 D:\nio_img文件夹中wx_lagou.jpg 复制到工程中
     * @param args
     */
    public static void main(String[] args) throws IOException {

        // 创建输入流和输出流（依赖于IO流获取channel）
        FileInputStream fileInputStream = new FileInputStream("D:\\nio_img\\wx_lagou.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\NIO\\复制.jpg");


        // 通过IO流获取channel通道
        FileChannel channel1 = fileInputStream.getChannel();
        FileChannel channel2 = fileOutputStream.getChannel();


        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 循环读写
        while (channel1.read(byteBuffer) != -1){
            byteBuffer.flip();
            channel2.write(byteBuffer);
            byteBuffer.clear();
        }

        //关流
        fileInputStream.close();
        fileOutputStream.close();

    }
}
