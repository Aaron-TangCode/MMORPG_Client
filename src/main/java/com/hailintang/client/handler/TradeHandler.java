package com.hailintang.client.handler;

import com.hailintang.client.protobuf.protoc.MsgTradeInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName TradeHandler
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/13 12:15
 * @Version 1.0
 */
public class TradeHandler extends SimpleChannelInboundHandler<MsgTradeInfoProto.ResponseTradeInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgTradeInfoProto.ResponseTradeInfo responseTradeInfo) throws Exception {
        System.out.println(responseTradeInfo.getContent());
    }
}
