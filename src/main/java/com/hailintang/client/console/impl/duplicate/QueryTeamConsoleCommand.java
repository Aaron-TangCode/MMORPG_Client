package com.hailintang.client.console.impl.duplicate;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgBossInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName QueryTeamConsoleCommand
 * @Description 查询队伍
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class QueryTeamConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        //打包成protobuf格式
        MsgBossInfoProto.RequestBossInfo requestBossInfo = MsgBossInfoProto.RequestBossInfo.newBuilder()
                .setType(MsgBossInfoProto.RequestType.QUERYTEAM)
                .build();
        //输出
        channel.writeAndFlush(requestBossInfo);
    }
}
