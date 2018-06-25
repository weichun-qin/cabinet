package com.qin.cabinettest.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer {

    public static void createSokcet(int port, OnSocketListener listener) {
        try {
            //建立socket服务器
            ServerSocket ss = new ServerSocket(8888);
            //开启接收线程
            new SocketThread(ss,listener).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface OnSocketListener {
        void onRecieve(String msg);
    }
}
