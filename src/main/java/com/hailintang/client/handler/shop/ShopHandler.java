package com.hailintang.client.handler.shop;

import com.hailintang.client.protobuf.protoc.MsgShopInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName ShopHandler
 * @Description 购物处理器
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
