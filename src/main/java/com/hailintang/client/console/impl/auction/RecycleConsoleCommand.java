package com.hailintang.client.console.impl.auction;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgAuctionInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName RecycleConsoleCommand
 * @Description 下架物品
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class RecycleConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请输入AuctionId:");

        String auctionId = scanner.next();

        if (Strings.isNullOrEmpty(auctionId)){
            System.out.println("尚未输入信息，请重新发送 Recycle 指令");
            return;
        }


        MsgAuctionInfoProto.RequestAuctionInfo requestAuctionInfo = MsgAuctionInfoProto.RequestAuctionInfo.newBuilder()
                .setType(MsgAuctionInfoProto.RequestType.RECYCLE)
                .setAuctionId(auctionId)
                .build();

        channel.writeAndFlush(requestAuctionInfo);
    }
}
