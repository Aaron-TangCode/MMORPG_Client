package com.hailintang.client.console.impl.trade;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import com.hailintang.client.protobuf.protoc.MsgTradeInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName RequestTradeConsoleCommand
 * @Description 请求交易
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class RequestTradeConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请选择交易角色:");

        String target = scanner.next();

        if (Strings.isNullOrEmpty(target)){
            System.out.println("尚未输入信息，请重新发送 RequestTrade 指令");
            return;
        }

        MsgTradeInfoProto.RequestTradeInfo requestTradeInfo = MsgTradeInfoProto.RequestTradeInfo.newBuilder()
                .setType(MsgTradeInfoProto.RequestType.REQUESTTRADE)
                .setRoleName(target)
                .setRequestId(UUID.randomUUID().toString())
                .build();

        channel.writeAndFlush(requestTradeInfo);
    }
}
