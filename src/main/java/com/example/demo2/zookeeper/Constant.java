package com.example.demo2.zookeeper;

public interface Constant {
    String ZK_CONNECTION_STRING = "172.18.95.112:2181,172.18.95.112:2182,172.18.95.112:2183";
    int ZK_SESSION_TIMEOUT = 5000;
    String ZK_REGISTRY_PATH = "/registry";
    String ZK_PROVIDER_PATH = ZK_REGISTRY_PATH + "/provider" ;
}
