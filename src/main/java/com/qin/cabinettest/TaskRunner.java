package com.qin.cabinettest;

import com.qin.cabinettest.httpClient.HttpAPIService;
import com.qin.cabinettest.model.Cabinet;
import com.qin.cabinettest.service.serviceImpl.CabinetServiceImpl;
import com.qin.cabinettest.socket.SocketServer;
import com.qin.cabinettest.socket.SocketServer.OnSocketListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TaskRunner implements CommandLineRunner{

    @Autowired
    private HttpAPIService httpAPIService;
    @Autowired
    private CabinetServiceImpl cabinetService;

    private String url = "http://192.168.1.133:1532/simple/tarsier/simple/ci/import";

    private int count;
    @Override
    public void run(String... args) throws Exception {
        SocketServer.createSokcet(8888, new OnSocketListener() {

            @Override
            public void onRecieve(String msg) {
                // TODO Auto-generated method stub
                resolveData(msg);
            }
        });
    }

    public void resolveData(String msg){
        System.out.println(msg);
        String[] dataAttr = msg.split(",");
        Cabinet data = new Cabinet();
        data.setClassname("8");
        data.setCode(dataAttr[1]);
        data.setBelong(dataAttr[0]);
        data.setUnitType("hp");
        data.setName("hp");
        data.setuBit(dataAttr[2]);

        if(cabinetService.update(data)>0){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
/*
        dataMap.put("编号",dataAttr[1]);
        dataMap.put("名称","hp");
        dataMap.put("所属",dataAttr[0]);
        dataMap.put("设备型号","hp");
        dataMap.put("U位",dataAttr[2]);
        map.put("classname","架式设备");
        map.put("data",dataMap);
        try {
            System.out.println("测试成功,msg:"+httpAPIService.doPost(url,map).getData()+"   "+httpAPIService.doPost(url,map).getStatus());
        } catch (Exception e) {

        }
*/
    }

}
