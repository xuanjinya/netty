package com.huang.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
//从本地文件读取 数据
public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception {
        //创建文件的输入流
        File file = new File("E:\\file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        //创建文件的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //将缓冲区的数据读入到通道中
        fileChannel.read(byteBuffer);
        //将字节转换为字符串
        System.out.println(new String(byteBuffer.array()));
        //关闭流
        fileInputStream.close();
    }
}
