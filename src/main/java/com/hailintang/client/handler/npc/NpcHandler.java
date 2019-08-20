package com.hailintang.client.handler.npc;

import com.hailintang.client.protobuf.protoc.MsgNpcInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName NpcHandler
 * @Description npc处理器
 * @Author DELL
 * @Date 2019/8/12 10:14
 * @Version 1.0
 */
public class NpcHandler extends SimpleChannelInboundHandler<MsgNpcInfoProto.ResponseNpcInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgNpcInfoProto.ResponseNpcInfo responseNpcInfo) throws Exception {
        System.out.println(responseNpcInfo.getContent());
    }
}
