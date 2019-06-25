package com.example.demo2.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
    String sayHello(String param) throws RemoteException;
}
