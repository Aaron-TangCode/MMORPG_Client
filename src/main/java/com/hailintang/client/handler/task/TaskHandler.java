package com.hailintang.client.handler.task;

import com.hailintang.client.protobuf.protoc.MsgAuctionInfoProto;
import com.hailintang.client.protobuf.protoc.MsgTaskInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName AuctionHandler
 * @Description 拍卖行处理器
 * @Author DELL
 * @Date 2019/8/13 16:41
 * @Version 1.0
 */
public class TaskHandler extends SimpleChannelInboundHandler<MsgTaskInfoProto.ResponseTaskInfo> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgTaskInfoProto.ResponseTaskInfo responseTaskInfo) throws Exception {
        System.out.println(responseTaskInfo.getContent());
    }
}
