package com.hailintang.client.handler;

import com.hailintang.client.protobuf.protoc.MsgEquipInfoProto;
import com.hailintang.client.protobuf.protoc.MsgGoodsInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName MapHandler
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/9 15:08
 * @Version 1.0
 */
public class EquipHandler extends SimpleChannelInboundHandler<MsgEquipInfoProto.ResponseEquipInfo> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgEquipInfoProto.ResponseEquipInfo responseEquipInfo) throws Exception {
        System.out.println(responseEquipInfo.getContent());
    }
}
