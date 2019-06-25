package com.example.demo2;

import com.example.demo2.service.HelloService;
import com.example.demo2.zookeeper.ServiceConsumer;

import java.rmi.RemoteException;

public class ZookeeperClient {
    public static void main(String[] args) {
        ServiceConsumer consumer = new ServiceConsumer();

        while (true ) {
            HelloService helloService = consumer .lookup();
            String result = null;
            try {
                result = helloService .sayHello("Jack");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            System. out.println(result );
            try {
                Thread. sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
