package com.huang.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOService {
    public static void main(String[] args) throws Exception {
        //创建一个线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动。。。");
        while (true) {
            //监听等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            //如果有客户端连接，创建一个线程
            newCachedThreadPool.execute(new Runnable() {
                public void run() { //重写run方法
                    //可以与客户端通讯
                    handle(socket);
                }
            });
        }
    }

    //编写一个handle方法和客户端通讯
    public static void handle(Socket socket) {
        byte[] bytes = new byte[1024];
        //通过socket 获取输入流
        try {
            InputStream inputStream = socket.getInputStream();
            //循环读取客户端发送的数据
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println("输出客户端发送的数据" + new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
