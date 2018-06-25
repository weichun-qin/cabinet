package com.qin.cabinettest.socket;

import com.qin.cabinettest.TaskRunner;
import com.qin.cabinettest.socket.RecieveThread.Imsg;
import com.qin.cabinettest.socket.SocketServer.OnSocketListener;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;

public class SocketThread extends Thread{
    private ServerSocket ss;
    private OnSocketListener listener;
    private Logger logger = LoggerFactory.getLogger(TaskRunner.class);
    public SocketThread(ServerSocket ss, OnSocketListener listener) {
        this.ss=ss;
        this.listener = listener;
    }
    public void run() {
        logger.info("-------Socket监听线程启动-------");
        try {
            while (true) {
                logger.info("开启新的监听，端口号:8888");
                System.out.println("开启监听");
                Socket s = ss.accept();
                // 启动接受消息线程
                new RecieveThread(s, new Imsg() {
                    @Override
                    public void onRecieve(String msg) {
                        listener.onRecieve(msg);
                    }
                }).start();

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error(e.getMessage());
        }
    }
}
