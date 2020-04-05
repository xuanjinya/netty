package com.huang.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NIOFileChannel04 {
    public static void main(String[] args) throws Exception {
        //创建相关的流
        FileInputStream fileInputStream = new FileInputStream("a.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("b.jpg");
        //获取流的对应的channle对象
        FileChannel sourceCh = fileInputStream.getChannel();
        FileChannel destch = fileOutputStream.getChannel();
        //使用transferFrom完成拷贝
        destch.transferFrom(sourceCh, 0, sourceCh.size());
        //关闭相关的通道
        sourceCh.close();
        destch.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
