package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgEmailInfoProto;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName ChooseRoleConsoleCommand
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class SendGoodsConsoleCommand implements ConsoleCommand{
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请输入物品名称:");

        String goodsName = scanner.next();

        if (Strings.isNullOrEmpty(goodsName)){
            System.out.println("尚未输入信息，请重新发送 SendGoods 指令");
            return;
        }

        MsgEmailInfoProto.RequestEmailInfo requestEmailInfo = MsgEmailInfoProto.RequestEmailInfo.newBuilder()
                .setType(MsgEmailInfoProto.RequestType.SENDGOODS)
                .setGoodsName(goodsName)
                .setRequestId(UUID.randomUUID().toString())
                .build();

        channel.writeAndFlush(requestEmailInfo);
    }
}
