package com.lagou.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIO服务器 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // 1.创建服务器端对象，监听对应的端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 绑定要监听的端口
        serverSocketChannel.bind(new InetSocketAddress(9999));

        // 设置为非阻塞连接
        serverSocketChannel.configureBlocking(false);


        while (true) {
            // 2.连接客户端 阻塞
            SocketChannel socketChannel = serverSocketChannel.accept();

            if (socketChannel != null) {

                // 3.读取数据
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                // 读取到的字节长度
                int len = socketChannel.read(byteBuffer);

                // 打印
                System.out.println(new String(byteBuffer.array(), 0, len));

                // 结束循环
                break;

            }else {

                // 没有连接到服务器的客户端
                System.out.println("做一些别的事");
                Thread.sleep(2000);

            }
        }
    }
}
