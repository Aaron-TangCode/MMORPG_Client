package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgMapInfoProto;
import com.hailintang.client.protobuf.protoc.MsgUserInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName GetMapConsoleCommand
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/9 14:44
 * @Version 1.0
 */
public class GetMapConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        String order = scanner.next();

        if (Strings.isNullOrEmpty(order)){
            System.out.println("尚未指令，请重新发送 order 指令");
            return;
        }

        //打包成protobuf格式
        MsgMapInfoProto.RequestMapInfo requestMapInfo = MsgMapInfoProto.RequestMapInfo.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setType(MsgMapInfoProto.RequestType.GETMAP)
                .build();
        //输出
        channel.writeAndFlush(requestMapInfo);
    }
}
