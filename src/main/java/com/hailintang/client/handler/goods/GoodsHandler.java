package com.hailintang.client.handler.goods;

import com.hailintang.client.protobuf.protoc.MsgGoodsInfoProto;
import com.hailintang.client.protobuf.protoc.MsgMapInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName GoodsHandler
 * @Description 物品处理器
 * @Author DELL
 * @Date 2019/8/9 15:08
 * @Version 1.0
 */
public class GoodsHandler extends SimpleChannelInboundHandler<MsgGoodsInfoProto.ResponseGoodsInfo> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgGoodsInfoProto.ResponseGoodsInfo responseGoodsInfo) throws Exception {
        System.out.println(responseGoodsInfo.getContent());
    }
}
