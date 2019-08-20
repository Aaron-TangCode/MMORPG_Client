package com.hailintang.client.console.impl.task;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgTaskInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName DiscardTaskConsoleCommand
 * @Description 放弃任务
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class DiscardTaskConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入任务id");
        String taskId = scanner.next();

        if (Strings.isNullOrEmpty(taskId)){
            System.out.println("尚未指令，请重新发送 DiscardTask 指令");
            return;
        }

        //打包成protobuf格式
        MsgTaskInfoProto.RequestTaskInfo requestTaskInfo = MsgTaskInfoProto.RequestTaskInfo.newBuilder()
                .setType(MsgTaskInfoProto.RequestType.DISCARDTASK)
                .setRequestId(UUID.randomUUID().toString())
                .build();
        //输出
        channel.writeAndFlush(requestTaskInfo);
    }
}
