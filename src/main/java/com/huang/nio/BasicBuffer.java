package com.huang.nio;


import java.nio.IntBuffer;

public class BasicBuffer {
    public static void main(String[] args) {
        //举例说明Buffer的使用
        //创建一个Buffer 可以存放5个Int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i*2);
        }
        //取出数据，需要读写转换 filp()
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            int i = intBuffer.get();
            System.out.println(i);
        }
    }
}
