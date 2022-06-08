package com.lagou.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIO客户端 {

    public static void main(String[] args) throws IOException {


        // 1. 创建对象
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8888));

        // 创建缓冲区数组
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 设置数据
        byteBuffer.put("哈哈哈".getBytes());

        byteBuffer.flip();

        // 输出数据
        socketChannel.write(byteBuffer);

        socketChannel.close();

    }
}
