package com.hailintang.client.handler.email;

import com.hailintang.client.protobuf.protoc.MsgEmailInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName EmailHandler
 * @Description 邮件处理器
 * @Author DELL
 * @Date 2019/8/13 11:07
 * @Version 1.0
 */
public class EmailHandler extends SimpleChannelInboundHandler<MsgEmailInfoProto.ResponseEmailInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgEmailInfoProto.ResponseEmailInfo responseEmailInfo) throws Exception {
        System.out.println(responseEmailInfo.getContent());
    }
}
