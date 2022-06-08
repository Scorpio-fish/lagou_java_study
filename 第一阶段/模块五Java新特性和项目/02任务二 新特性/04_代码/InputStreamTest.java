package com.lagou.task22;

import java.io.*;

public class InputStreamTest {

    public static void main(String[] args) {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("d:/a.txt");
            outputStream = new FileOutputStream("d:/b.txt");
            inputStream.transferTo(outputStream); // 实现数据的复制，底层是read和write方法的调用
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
