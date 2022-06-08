package com.lagou.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Selector服务器 {

    public static void main(String[] args) throws IOException {

        // 小目标：通道注册到选择器上：实现

        // 1、获取seletor选择器
        Selector selector = Selector.open();

        // 2、获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocketChannel serverSocketChanne2 = ServerSocketChannel.open();
        ServerSocketChannel serverSocketChanne3 = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(9999));
        serverSocketChanne2.bind(new InetSocketAddress(8888));
        serverSocketChanne3.bind(new InetSocketAddress(7777));

        // 3、设置为非阻塞 ** （与selector一起使用时，channel必须要处在非阻塞模式下，如果是阻塞的，会抛出异常）
        serverSocketChannel.configureBlocking(false);
        serverSocketChanne2.configureBlocking(false);
        serverSocketChanne3.configureBlocking(false);

        // 4、将通道注册到选择器上 指定 监听事件 为 ‘接收’事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        serverSocketChanne2.register(selector, SelectionKey.OP_ACCEPT);
        serverSocketChanne3.register(selector, SelectionKey.OP_ACCEPT);


        // select():查询已经就绪的通道操作 返回值：表示有多少通道已经就绪
        //  阻塞：阻塞到至少有一个通道上的事件就绪了

        // 5、采用轮询的方式，查询准备就绪的事件
        while (selector.select() > 0){

            // 6、集合中就是所有已经准备就绪的操作集合
            Set<SelectionKey> set = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeys = set.iterator();

            while (selectionKeys.hasNext()){

                // 7、已经‘准备就绪’的事件
                SelectionKey selectionKey = selectionKeys.next();

                //8、判断事件的类型 ---ACCEPT
                ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();

                // 9、接收客户端发送过来的数据
                SocketChannel socketChannel = serverSocketChannel1.accept();

                // 10、读取数据
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int len = socketChannel.read(byteBuffer);

                // 11、打印
                System.out.println(new String(byteBuffer.array(),0,len));

                // 12、资源关闭
                socketChannel.close();

            }
            selectionKeys.remove();
            }

        serverSocketChannel.close();
        serverSocketChanne2.close();
        serverSocketChanne3.close();


    }
}
