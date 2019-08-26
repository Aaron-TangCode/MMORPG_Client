package com.hailintang.client.console.impl.duplicate;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgBossInfoProto;
import com.hailintang.client.protobuf.protoc.MsgEquipInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName EnterDuplicateConsoleCommand
 * @Description 攻击怪兽
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class EnterDuplicateConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入地图名称，技能名称(mapName)");
        String mapName = scanner.next();

        if (Strings.isNullOrEmpty(mapName)){
            System.out.println("尚未指令，请重新发送 EnterDuplicate 指令");
            return;
        }
        //打包成protobuf格式
        MsgBossInfoProto.RequestBossInfo requestBossInfo = MsgBossInfoProto.RequestBossInfo.newBuilder()
                .setType(MsgBossInfoProto.RequestType.ENTERDUPLICATE)
                .setMapName(mapName)
                .build();
        //输出
        channel.writeAndFlush(requestBossInfo);
    }
}
