package com.lagou.buffer;

import java.nio.ByteBuffer;

public class Demo03Buffer的核心属性 {

    public static void main(String[] args) {

        // 1. 创建出buffer对象
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println("初始化---->capacity--->" + byteBuffer.capacity());
        System.out.println("初始化---->limit--->" + byteBuffer.limit());
        System.out.println("初始化---->position--->" + byteBuffer.position());

        System.out.println("-----------------------------");

        // 添加一些数据到缓冲区
        String s = "JavaEE";
        byteBuffer.put(s.getBytes());

        System.out.println("put后---->capacity--->" + byteBuffer.capacity());
        System.out.println("put后---->limit--->" + byteBuffer.limit());
        System.out.println("put后---->position--->" + byteBuffer.position());

        System.out.println("-----------------------------");

            byteBuffer.flip();
        System.out.println("flip后---->capacity--->" + byteBuffer.capacity());
        System.out.println("flip后---->limit--->" + byteBuffer.limit());
        System.out.println("flip后---->position--->" + byteBuffer.position());

        System.out.println("-----------------------------");

        // （1）创建一个limit()大小的字节数组(因为就只有limit这么多个数据可读)
        byte[] bytes = new byte[byteBuffer.limit()];

        // (2) 将读取出来的数据装进字节数组中
        byteBuffer.get(bytes);

        System.out.println("get后---->capacity--->" + byteBuffer.capacity());
        System.out.println("get后---->limit--->" + byteBuffer.limit());
        System.out.println("get后---->position--->" + byteBuffer.position());

        // (3) 输出数据
        System.out.println(new String(bytes,0,bytes.length));

        byteBuffer.clear();
        System.out.println("clear后---->capacity--->" + byteBuffer.capacity());
        System.out.println("clear后---->limit--->" + byteBuffer.limit());
        System.out.println("clear后---->position--->" + byteBuffer.position());


        byteBuffer.put("lagou".getBytes());
        System.out.println("第一次put后---->position--->" + byteBuffer.position());

        // 做一个标记：记录上一次读写位置 position的值 5
        byteBuffer.mark();

        byteBuffer.put("zimu".getBytes());
        System.out.println("第二次put后---->position--->" + byteBuffer.position());

        // 还原到标记位置
        byteBuffer.reset();
        System.out.println("reset后---->position--->" + byteBuffer.position());





    }
}
