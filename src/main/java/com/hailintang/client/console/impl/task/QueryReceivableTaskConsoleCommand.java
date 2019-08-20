package com.hailintang.client.console.impl.task;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgShopInfoProto;
import com.hailintang.client.protobuf.protoc.MsgTaskInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName QueryReceivableTaskConsoleCommand
 * @Description 查询可接受任务
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class QueryReceivableTaskConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        //打包成protobuf格式
        MsgTaskInfoProto.RequestTaskInfo requestTaskInfo = MsgTaskInfoProto.RequestTaskInfo.newBuilder()
                .setType(MsgTaskInfoProto.RequestType.QUERYRECEIVABLETASK)
                .setRequestId(UUID.randomUUID().toString())
                .build();
        //输出
        channel.writeAndFlush(requestTaskInfo);
    }
}
