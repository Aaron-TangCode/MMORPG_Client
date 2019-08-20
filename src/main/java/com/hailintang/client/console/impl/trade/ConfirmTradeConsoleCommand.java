package com.hailintang.client.console.impl.trade;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import com.hailintang.client.protobuf.protoc.MsgTradeInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName ConfirmTradeConsoleCommand
 * @Description 确认交易
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class ConfirmTradeConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请输入角色和确认码：（roleName,uuid）");

        String confirm = scanner.next();

        if (Strings.isNullOrEmpty(confirm)){
            System.out.println("尚未输入信息，请重新发送 ConfirmTrade 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = confirm.split(",");
        String roleName = strArr[0];
        String uuid = strArr[1];
        if (Strings.isNullOrEmpty(roleName) || Strings.isNullOrEmpty(uuid)){
            System.out.println("角色名或职业id为空，请重新发送 ConfirmTrade 指令");
            return;
        }

        MsgTradeInfoProto.RequestTradeInfo requestTradeInfo = MsgTradeInfoProto.RequestTradeInfo.newBuilder()
                .setRoleName(roleName)
                .setUuid(uuid)
                .setType(MsgTradeInfoProto.RequestType.CONFIRMTRADE)
                .build();

        channel.writeAndFlush(requestTradeInfo);
    }
}
