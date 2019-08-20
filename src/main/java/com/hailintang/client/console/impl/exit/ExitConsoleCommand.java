package com.hailintang.client.console.impl.exit;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.local.LocalUserData;
import com.hailintang.client.protobuf.protoc.MsgEquipInfoProto;
import com.hailintang.client.protobuf.protoc.MsgUserInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName ExitConsoleCommand
 * @Description 退出游戏
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class ExitConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        int userId = LocalUserData.getUserId();
        if (userId <= 0){
            System.out.println("当前用户尚未登录服务器，请进行登录操作!\n 具体登录指令：login");
            return;
        }

        MsgUserInfoProto.RequestUserInfo requestUserInfo = MsgUserInfoProto.RequestUserInfo.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setUserId(userId)
                .setType(MsgUserInfoProto.RequestType.EXIT)
                .build();

        channel.writeAndFlush(requestUserInfo);
    }
}
