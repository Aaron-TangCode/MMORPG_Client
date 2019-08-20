package com.hailintang.client.console.impl.auction;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgAuctionInfoProto;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName BiddingConsoleCommand
 * @Description 拍卖
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class BiddingConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请创建AuctionId和竞拍金额：（auctionId,money）");

        String bidding = scanner.next();

        if (Strings.isNullOrEmpty(bidding)){
            System.out.println("尚未输入信息，请重新发送 Bidding 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = bidding.split(",");
        String auctionId = strArr[0];
        String money = strArr[1];
        if (Strings.isNullOrEmpty(auctionId) || Strings.isNullOrEmpty(money)){
            System.out.println("AuctionId或竞拍金额为空，请重新发送 Bidding 指令");
            return;
        }

        MsgAuctionInfoProto.RequestAuctionInfo requestAuctionInfo = MsgAuctionInfoProto.RequestAuctionInfo.newBuilder()
                .setType(MsgAuctionInfoProto.RequestType.BIDDING)
                .setAuctionId(auctionId)
                .setMoney(money)
                .build();

        channel.writeAndFlush(requestAuctionInfo);
    }
}
