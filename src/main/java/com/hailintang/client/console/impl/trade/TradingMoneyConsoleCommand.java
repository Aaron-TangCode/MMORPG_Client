package com.hailintang.client.console.impl.trade;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import com.hailintang.client.protobuf.protoc.MsgTradeInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName TradingMoneyConsoleCommand
 * @Description 交易金额
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class TradingMoneyConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请输入确认码和金币:(uuid,money)");

        String accountInfo = scanner.next();

        if (Strings.isNullOrEmpty(accountInfo)){
            System.out.println("尚未输入信息，请重新发送 TradingMoney 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = accountInfo.split(",");
        String uuid = strArr[0];
        String number = strArr[1];
        if (Strings.isNullOrEmpty(uuid) || Strings.isNullOrEmpty(number)){
            System.out.println("确认码或数量为空，请重新发送 TradingMoney 指令");
            return;
        }

        MsgTradeInfoProto.RequestTradeInfo requestTradeInfo = MsgTradeInfoProto.RequestTradeInfo.newBuilder()
                .setType(MsgTradeInfoProto.RequestType.TRADINGMONEY)
                .setUuid(uuid)
                .setNumber(number)
                .setRequestId(UUID.randomUUID().toString())
                .build();

        channel.writeAndFlush(requestTradeInfo);
    }
}
