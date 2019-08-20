package com.hailintang.client.console.impl.trade;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import com.hailintang.client.protobuf.protoc.MsgTradeInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName TradingGoodsConsoleCommand
 * @Description 交易
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class TradingGoodsConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请输入确认码和物品:(uuid,goodsName)");

        String accountInfo = scanner.next();

        if (Strings.isNullOrEmpty(accountInfo)){
            System.out.println("尚未输入信息，请重新发送 TradingGoods 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = accountInfo.split(",");
        String uuid = strArr[0];
        String goodsName = strArr[1];
        if (Strings.isNullOrEmpty(uuid) || Strings.isNullOrEmpty(goodsName)){
            System.out.println("角色名或职业id为空，请重新发送 TradingGoods 指令");
            return;
        }

        MsgTradeInfoProto.RequestTradeInfo requestTradeInfo = MsgTradeInfoProto.RequestTradeInfo.newBuilder()
                .setType(MsgTradeInfoProto.RequestType.TRADINGGOODS)
                .setUuid(uuid)
                .setGoodsName(goodsName)
                .build();

        channel.writeAndFlush(requestTradeInfo);
    }
}
