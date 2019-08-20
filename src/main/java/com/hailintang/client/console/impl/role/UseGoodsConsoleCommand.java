package com.hailintang.client.console.impl.role;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName UseGoodsConsoleCommand
 * @Description 使用物品
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class UseGoodsConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请输入物品名称:");

        String goodsName = scanner.next();

        if (Strings.isNullOrEmpty(goodsName)){
            System.out.println("尚未输入信息，请重新发送 UseGoods 指令");
            return;
        }


        MsgRoleInfoProto.RequestRoleInfo requestRoleInfo = MsgRoleInfoProto.RequestRoleInfo.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setGoodsName(goodsName)
                .setType(MsgRoleInfoProto.RequestType.USEGOODS)
                .build();

        channel.writeAndFlush(requestRoleInfo);
    }
}
