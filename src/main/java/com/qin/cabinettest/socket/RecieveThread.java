package com.qin.cabinettest.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecieveThread extends Thread{
    private Socket s;
    private Imsg imsg;
    private Logger logger = LoggerFactory.getLogger(RecieveThread.class);

    public RecieveThread(Socket s, Imsg imsg) {
        this.s = s;
        this.imsg = imsg;
    }

    /*SendServer sendServer = new SendServer();*/

    public void run() {
        try {
            // 读取客户端数据
            DataInputStream input = new DataInputStream(s.getInputStream());
            BufferedReader bf = new BufferedReader(new InputStreamReader(input,"utf-8"));
            // 读取客户端发送来的消息
            String msg;
            while ((msg = bf.readLine()) != null) {
                imsg.onRecieve(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }



    interface Imsg {
        void onRecieve(String msg);
    }
}
