package com.hailintang.client.console.impl.task;

import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgTaskInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName QueryReceivedTaskConsoleCommand
 * @Description 查询已接受任务
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class QueryReceivedTaskConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        //打包成protobuf格式
        MsgTaskInfoProto.RequestTaskInfo requestTaskInfo = MsgTaskInfoProto.RequestTaskInfo.newBuilder()
                .setType(MsgTaskInfoProto.RequestType.QUERYRECEIVEDTASK)
                .setRequestId(UUID.randomUUID().toString())
                .build();
        //输出
        channel.writeAndFlush(requestTaskInfo);
    }
}
