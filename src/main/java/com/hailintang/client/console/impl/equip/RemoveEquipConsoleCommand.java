package com.hailintang.client.console.impl.equip;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgEquipInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName RemoveEquipConsoleCommand
 * @Description 移除装备
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class RemoveEquipConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入装备名称");
        String goodsName = scanner.next();

        if (Strings.isNullOrEmpty(goodsName)){
            System.out.println("尚未指令，请重新发送 RemoveEquip 指令");
            return;
        }

        //打包成protobuf格式
        MsgEquipInfoProto.RequestEquipInfo requestEquipInfo = MsgEquipInfoProto.RequestEquipInfo.newBuilder()
                .setType(MsgEquipInfoProto.RequestType.REMOVEEQUIP)
                .setGoodsName(goodsName)
                .build();
        //输出
        channel.writeAndFlush(requestEquipInfo);
    }
}
