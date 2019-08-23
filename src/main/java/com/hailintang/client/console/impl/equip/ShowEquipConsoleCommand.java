package com.hailintang.client.console.impl.equip;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgEquipInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName ShowEquipConsoleCommand
 * @Description 显示装备栏
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class ShowEquipConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //打包成protobuf格式
        MsgEquipInfoProto.RequestEquipInfo requestEquipInfo = MsgEquipInfoProto.RequestEquipInfo.newBuilder()
                .setType(MsgEquipInfoProto.RequestType.SHOWEQUIP)
                .build();
        //输出
        channel.writeAndFlush(requestEquipInfo);
    }
}
