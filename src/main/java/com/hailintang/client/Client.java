package com.hailintang.client;



import com.google.protobuf.MessageLite;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Client
 * @Description TODO
 * @Author DELL
 * @Date 2019/5/2712:18
 * @Version 1.0
 */
@Component
public class Client {

    private Bootstrap bootstrap;

    private Channel channel;

    public void start() {
        EventLoopGroup clientGroup = new NioEventLoopGroup();

        bootstrap = new Bootstrap();

        bootstrap.group(clientGroup).channel(NioSocketChannel.class)
                .handler(new ClientInitializer());

        doConnect();
    }

    /**
     * 重连服务器操作
     */
    protected void doConnect(){
        if (channel != null && channel.isActive()){
            return;
        }

        ChannelFuture channelFuture = bootstrap.connect("localhost",8899);

        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()){
                    channel = channelFuture.channel();
                    System.out.println(("Connect to Server Successfully!"));
                }else {
                    System.out.println(("Failed to connect to server, try connect after 5s"));

                    channelFuture.channel().eventLoop().schedule(() -> {
                        doConnect();
                    }, 5, TimeUnit.SECONDS);
                }
            }
        });
    }
    public Channel getChannel(){
        return channel;
    }

    public void sendMsg(MessageLite messageLite){
        channel.writeAndFlush(messageLite);
    }
}
