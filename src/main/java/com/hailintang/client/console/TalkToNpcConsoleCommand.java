package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgNpcInfoProto;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName ChooseRoleConsoleCommand
 * @Description 和npc交谈
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class TalkToNpcConsoleCommand implements ConsoleCommand{
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请选择NPC：(npcName)");

        String npcName = scanner.next();

        if (Strings.isNullOrEmpty(npcName)){
            System.out.println("尚未输入信息，请重新发送 TalkToNpc 指令");
            return;
        }
        //打包成protobuf协议
        MsgNpcInfoProto.RequestNpcInfo requestNpcInfo = MsgNpcInfoProto.RequestNpcInfo.newBuilder()
                .setType(MsgNpcInfoProto.RequestType.TALKTONPC)
                .setRequestId(UUID.randomUUID().toString())
                .setNpcName(npcName)
                .build();

        channel.writeAndFlush(requestNpcInfo);
    }
}
