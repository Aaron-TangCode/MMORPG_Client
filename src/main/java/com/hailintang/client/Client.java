package com.hailintang.client;



import com.google.protobuf.MessageLite;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Client
 * @Description TODO
 * @Author DELL
 * @Date 2019/5/2712:18
 * @Version 1.0
 */
@Component
public class Client {
//    public static void main(String[] args) {
//        Client client = new Client();
//        client.start();
//    }
    private Channel channel;
    public void start() {
        EventLoopGroup clientGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(clientGroup).channel(NioSocketChannel.class)
                    .handler(new ClientInitializer());

            //channel = bootstrap.connect("localhost", 8899).sync().channel();
            ChannelFuture future = bootstrap.connect("localhost", 8899).sync();
            if (future.isSuccess()){
                System.out.println("成功连接服务器......");
            }
            channel = future.channel();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            for (;;){
//                channel.writeAndFlush(bufferedReader.readLine()+"\r\n");
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Channel getChannel(){
        return channel;
    }

    public void sendMsg(MessageLite messageLite){
        channel.writeAndFlush(messageLite);
    }
}
