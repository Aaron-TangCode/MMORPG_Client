package com.hailintang.client.console.impl.gang;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgGangInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName JoinGangConsoleCommand
 * @Description 加入工会
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class JoinGangConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入工会名称");
        String gangName = scanner.next();

        if (Strings.isNullOrEmpty(gangName)){
            System.out.println("尚未指令，请重新发送 JoinGang 指令");
            return;
        }

        //打包成protobuf格式
        MsgGangInfoProto.RequestGangInfo requestGangInfo = MsgGangInfoProto.RequestGangInfo.newBuilder()
                .setGangName(gangName)
                .setType(MsgGangInfoProto.RequestType.JOINGANG)
                .build();
        //输出
        channel.writeAndFlush(requestGangInfo);
    }
}
