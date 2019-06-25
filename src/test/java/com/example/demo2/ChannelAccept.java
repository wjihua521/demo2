package com.example.demo2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ChannelAccept {
    public static void main(String[] args) {
        String gre = "Hello I must be going.";
        ByteBuffer buffer = ByteBuffer.wrap(gre.getBytes());
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(8000));
            ssc.configureBlocking(false);

            while (true){
                System.out.println("waiting for connection...");
                SocketChannel sc = ssc.accept();
                if(sc==null){
                    System.out.println("no connection.");
                    continue;
                }else{
                    buffer.rewind();
                    sc.write(buffer);
                    sc.close();
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
