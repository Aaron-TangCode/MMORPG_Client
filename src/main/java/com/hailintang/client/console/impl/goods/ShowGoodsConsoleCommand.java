package com.hailintang.client.console.impl.goods;

import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgGoodsInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName GetGoodsConsoleCommand
 * @Description 显示物品
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class ShowGoodsConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //打包成protobuf格式
        MsgGoodsInfoProto.RequestGoodsInfo requestGoodsInfo = MsgGoodsInfoProto.RequestGoodsInfo.newBuilder()
                .setType(MsgGoodsInfoProto.RequestType.SHOWGOODS)
                .setRequestId(UUID.randomUUID().toString())
                .build();
        //输出
        channel.writeAndFlush(requestGoodsInfo);
    }
}
