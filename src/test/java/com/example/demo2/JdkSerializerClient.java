package com.example.demo2;

import com.example.demo2.dto.Request;
import com.example.demo2.dto.Response;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JdkSerializerClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ObjectEncoder());
                    ch.pipeline().addLast(new ObjectDecoder(new ClassResolver() {
                        public Class<?> resolve(String className) throws ClassNotFoundException {
                            return Class.forName(className);
                        }
                    }));
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                        // 在于server建立连接后，即发送请求报文
                        public void channelActive(ChannelHandlerContext ctx) {
                            Request request = new Request();
                            request.setRequest("i am request!");
                            HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
                            ArrayList list = new ArrayList<Integer>();
                            list. add(1);
                            list. add(2);
                            list. add(3);
                            map.put("names",list);
                            request.setMaps(map);
                            //request.setRequestTime(new Date());
                            ctx.writeAndFlush(request);
                        }
                        //接受服务端的响应
                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            Response response= (Response) msg;
                            System.out.println("receive response:"+response);
                        }
                    });
                }
            });
            // Start the client.
            ChannelFuture f = b.connect("127.0.0.1", 8080).sync(); // (5)
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
