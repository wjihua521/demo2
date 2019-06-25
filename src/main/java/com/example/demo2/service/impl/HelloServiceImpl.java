package com.example.demo2.service.impl;

import com.example.demo2.service.HelloService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    private static DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");

    public HelloServiceImpl() throws RemoteException{

    }

    @Override
    public String sayHello(String param) throws RemoteException{
        return String.format( "当前时间为：%s -->%s", DATEFORMAT.format(new Date()),param );
    }
}
