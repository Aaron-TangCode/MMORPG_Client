package com.hailintang.client.console.impl.duplicate;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgBossInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName DismissTeamConsoleCommand
 * @Description 解散队伍
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class DismissTeamConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入队伍名称(teamName)");
        String teamName = scanner.next();

        if (Strings.isNullOrEmpty(teamName)){
            System.out.println("尚未指令，请重新发送 DismissTeam 指令");
            return;
        }

        //打包成protobuf格式
        MsgBossInfoProto.RequestBossInfo requestBossInfo = MsgBossInfoProto.RequestBossInfo.newBuilder()
                .setType(MsgBossInfoProto.RequestType.DISMISSTEAM)
                .setTeamName(teamName)
                .build();
        //输出
        channel.writeAndFlush(requestBossInfo);
    }
}
