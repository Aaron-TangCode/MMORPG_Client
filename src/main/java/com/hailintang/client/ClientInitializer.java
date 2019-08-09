package com.hailintang.client;

import com.hailintang.client.codec.CustomProtobufDecoder;
import com.hailintang.client.codec.CustomProtobufEncoder;
import com.hailintang.client.handler.MapHandler;
import com.hailintang.client.handler.RoleHandler;
import com.hailintang.client.handler.UserInfoHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @ClassName ClientInitializer
 * @Description TODO
 * @Author DELL
 * @Date 2019/5/2712:30
 * @Version 1.0
 */
public class ClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("decoder",new CustomProtobufDecoder());
        pipeline.addLast("encoder",new CustomProtobufEncoder());

        // pipeline.addLast("clientHandler",new ClientHandler());
        pipeline.addLast("userInfoHandler",new UserInfoHandler());
        pipeline.addLast("roleHandler",new RoleHandler());
        pipeline.addLast("mapHandler",new MapHandler());

    }
}
