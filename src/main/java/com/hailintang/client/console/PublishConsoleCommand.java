package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgAuctionInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName ChooseRoleConsoleCommand
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class PublishConsoleCommand implements ConsoleCommand{
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请输入物品名称，物品数量，物品金额，竞拍模式or一口价模式，(goodsName,number,money,isNow)");

        String publish = scanner.next();

        if (Strings.isNullOrEmpty(publish)){
            System.out.println("尚未输入信息，请重新发送 Publish 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = publish.split(",");
        String goodsName = strArr[0];
        String number = strArr[1];
        String money = strArr[2];
        String isNow = strArr[3];
        if (Strings.isNullOrEmpty(goodsName) || Strings.isNullOrEmpty(number)|| Strings.isNullOrEmpty(money)|| Strings.isNullOrEmpty(isNow)){
            System.out.println("AuctionId或竞拍金额为空，请重新发送 Publish 指令");
            return;
        }

        MsgAuctionInfoProto.RequestAuctionInfo requestAuctionInfo = MsgAuctionInfoProto.RequestAuctionInfo.newBuilder()
                .setType(MsgAuctionInfoProto.RequestType.PUBLISH)
                .setGoodsName(goodsName)
                .setIsNow(isNow)
                .setMoney(money)
                .setNumber(number)
                .build();

        channel.writeAndFlush(requestAuctionInfo);
    }
}
