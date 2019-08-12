package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgMapInfoProto;
import com.hailintang.client.protobuf.protoc.MsgUserInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName MoveConsoleCommand
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/9 14:43
 * @Version 1.0
 */
public class MoveConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        // 读取输入
        System.out.println("输入目的地：(desc)");
        String desc = scanner.next();
        if (Strings.isNullOrEmpty(desc)){
            System.out.println("尚未输入指令，请重新发送 Move 指令");
            return;
        }
        //打包成protobuf格式
        MsgMapInfoProto.RequestMapInfo requestMapInfo = MsgMapInfoProto.RequestMapInfo.newBuilder()
                .setType(MsgMapInfoProto.RequestType.MOVE)
                .setRequestId(UUID.randomUUID().toString())
                .setDest(desc)
                .build();
        //输出
        channel.writeAndFlush(requestMapInfo);
    }
}
