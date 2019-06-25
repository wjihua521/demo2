package com.example.demo2;

import com.example.demo2.service.HelloService;
import com.example.demo2.service.impl.HelloServiceImpl;
import com.example.demo2.zookeeper.ServiceProvider;

import java.rmi.RemoteException;

public class ZookeeperServer3 {
    public static void main(String[] args) {
        /*if (args .length != 2) {
            System. err.println("please using command: java Server <rmi_host> <rmi_port>");
            System. exit(-1);
        }*/

        String host = "172.18.95.6";
        int port = 3099;

        ServiceProvider provider = new ServiceProvider();

        HelloService helloService = null;
        try {
            helloService = new HelloServiceImpl();
            provider.publish(helloService , host , port );
            try {
                Thread. sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
