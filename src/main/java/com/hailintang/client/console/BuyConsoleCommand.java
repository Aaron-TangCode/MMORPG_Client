package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgGoodsInfoProto;
import com.hailintang.client.protobuf.protoc.MsgShopInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName GetGoodsConsoleCommand
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class BuyConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入物品名称");
        String goodsName = scanner.next();

        if (Strings.isNullOrEmpty(goodsName)){
            System.out.println("尚未指令，请重新发送 Buy 指令");
            return;
        }

        //打包成protobuf格式
        MsgShopInfoProto.RequestShopInfo requestShopInfo = MsgShopInfoProto.RequestShopInfo.newBuilder()
                .setGoodsName(goodsName)
                .setType(MsgShopInfoProto.RequestType.BUY)
                .build();
        //输出
        channel.writeAndFlush(requestShopInfo);
    }
}
