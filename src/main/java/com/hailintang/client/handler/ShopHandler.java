package com.hailintang.client.handler;

import com.hailintang.client.protobuf.protoc.MsgShopInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName ShopHandler
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/12 18:16
 * @Version 1.0
 */
public class ShopHandler extends SimpleChannelInboundHandler<MsgShopInfoProto.ResponseShopInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgShopInfoProto.ResponseShopInfo responseShopInfo) throws Exception {
        System.out.println(responseShopInfo.getContent());
    }
}
