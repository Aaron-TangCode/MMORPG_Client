package com.hailintang.client.handler;

import com.hailintang.client.protobuf.protoc.MsgRankInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName RankHandler
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/13 20:07
 * @Version 1.0
 */
public class RankHandler extends SimpleChannelInboundHandler<MsgRankInfoProto.ResponseRankInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgRankInfoProto.ResponseRankInfo responseRankInfo) throws Exception {
        System.out.println(responseRankInfo.getContent());
    }
}
