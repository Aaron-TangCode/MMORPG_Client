package com.hailintang.client.handler;

import com.hailintang.client.protobuf.protoc.MsgGangInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName GangHandler
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/13 14:38
 * @Version 1.0
 */
public class GangHandler extends SimpleChannelInboundHandler<MsgGangInfoProto.ResponseGangInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgGangInfoProto.ResponseGangInfo responseGangInfo) throws Exception {
        System.out.println(responseGangInfo.getContent());
    }
}
