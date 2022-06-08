package com.lagou.channel;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * BIO: 同步阻塞
 */
public class Test客户端 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好呀".getBytes());
        outputStream.close();
        socket.close();

    }



}
