package com.hailintang.client.handler.auction;

import com.hailintang.client.protobuf.protoc.MsgAuctionInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName AuctionHandler
 * @Description 拍卖行处理器
 * @Author DELL
 * @Date 2019/8/13 16:41
 * @Version 1.0
 */
public class AuctionHandler extends SimpleChannelInboundHandler<MsgAuctionInfoProto.ResponseAuctionInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgAuctionInfoProto.ResponseAuctionInfo responseAuctionInfo) throws Exception {
        System.out.println(responseAuctionInfo.getContent());
    }
}
