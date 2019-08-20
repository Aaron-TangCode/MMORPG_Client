package com.hailintang.client.console.impl.map;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgMapInfoProto;
import com.hailintang.client.protobuf.protoc.MsgUserInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName GetMapConsoleCommand
 * @Description 获取地图信息
 * @Author DELL
 * @Date 2019/8/9 14:44
 * @Version 1.0
 */
public class GetMapConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //打包成protobuf格式
        MsgMapInfoProto.RequestMapInfo requestMapInfo = MsgMapInfoProto.RequestMapInfo.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setType(MsgMapInfoProto.RequestType.GETMAP)
                .build();
        //输出
        channel.writeAndFlush(requestMapInfo);
    }
}
