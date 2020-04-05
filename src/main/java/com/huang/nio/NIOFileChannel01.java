package com.huang.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//将数据写入到指定路径下的文件
public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception {
        String str = "Hello huang";
        //创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\file01.txt");
        //通过一个输出流 fileOutputStream 获取当前对应的FileChannel
        //fileChannel 真实类型是 FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();
        //创建一个缓冲区 byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将 Str 放入到  byteBuffer  字节形式
        byteBuffer.put(str.getBytes());
        //读写翻转
        byteBuffer.flip();
        //把缓冲区的数据写入到fileChannel
        fileChannel.write(byteBuffer);
        //关闭流
        fileOutputStream.close();
    }
}
