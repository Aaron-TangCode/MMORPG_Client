package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgChatInfoProto;
import com.hailintang.client.protobuf.protoc.MsgUserInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName LoginConsoleCommand
 * @Description 登录控制器
 * @Author DELL
 * @Date 2019/8/8 10:33
 * @Version 1.0
 */
public class ChatAllConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        // 读取输入
        System.out.println("输入聊天内容");
        String content = scanner.next();
        if (Strings.isNullOrEmpty(content)){
            System.out.println("尚未输入指令信息，请重新发送 ChatAll 指令");
            return;
        }

        //打包成protobuf格式
        MsgChatInfoProto.RequestChatInfo requestChatInfo = MsgChatInfoProto.RequestChatInfo.newBuilder()
                .setType(MsgChatInfoProto.RequestType.CHATALL)
                .setContent(content)
                .build();
        //输出
        channel.writeAndFlush(requestChatInfo);
    }

}
