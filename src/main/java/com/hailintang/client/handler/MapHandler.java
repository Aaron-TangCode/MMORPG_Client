package com.hailintang.client.handler;

import com.hailintang.client.protobuf.protoc.MsgMapInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static com.hailintang.client.local.RequestMapInfoType.GETMAP;
import static com.hailintang.client.local.RequestMapInfoType.MOVE;

/**
 * @ClassName MapHandler
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/9 15:08
 * @Version 1.0
 */
public class MapHandler extends SimpleChannelInboundHandler<MsgMapInfoProto.ResponseMapInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgMapInfoProto.ResponseMapInfo responseMapInfo) throws Exception {
        //输出返回消息
        System.out.println(responseMapInfo.getContent());
    }
}
