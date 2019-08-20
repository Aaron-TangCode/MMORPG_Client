package com.hailintang.client.handler.duplicate;

import com.hailintang.client.protobuf.protoc.MsgBossInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName DuplicateHandler
 * @Description 副本处理器
 * @Author DELL
 * @Date 2019/8/12 17:30
 * @Version 1.0
 */
public class DuplicateHandler extends SimpleChannelInboundHandler<MsgBossInfoProto.ResponseBossInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgBossInfoProto.ResponseBossInfo responseBossInfo) throws Exception {
        System.out.println(responseBossInfo.getContent());
    }
}
