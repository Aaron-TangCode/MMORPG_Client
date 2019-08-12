package com.hailintang.client.handler;

import com.hailintang.client.protobuf.protoc.MsgChatInfoProto;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName ChatHandler
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/12 21:02
 * @Version 1.0
 */
public class ChatHandler extends SimpleChannelInboundHandler<MsgChatInfoProto.ResponseChatInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgChatInfoProto.ResponseChatInfo responseChatInfo) throws Exception {
        System.out.println(responseChatInfo.getContent());
    }
}
