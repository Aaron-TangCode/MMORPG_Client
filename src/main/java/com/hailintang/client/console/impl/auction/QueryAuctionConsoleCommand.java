package com.hailintang.client.console.impl.auction;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgAuctionInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName QueryAuctionConsoleCommand
 * @Description 查询拍卖品
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class QueryAuctionConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("loading.....");

        MsgAuctionInfoProto.RequestAuctionInfo requestAuctionInfo = MsgAuctionInfoProto.RequestAuctionInfo.newBuilder()
                .setType(MsgAuctionInfoProto.RequestType.QUERYAUCTION)
                .build();

        channel.writeAndFlush(requestAuctionInfo);
    }
}
