package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgChatInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName LoginConsoleCommand
 * @Description 私聊
 * @Author DELL
 * @Date 2019/8/8 10:33
 * @Version 1.0
 */
public class ChatSomeoneConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        // 读取输入
        System.out.println("输入对象，内容：(target,content)");
        String chat = scanner.next();
        if (Strings.isNullOrEmpty(chat)){
            System.out.println("尚未输入指令信息，请重新发送 ChatSomeone 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = chat.split(",");
        if (strArr.length != 2){
            System.out.println("输入的参数有误，请重新发送 ChatSomeone 指令");
            return;
        }
        String target = strArr[0];
        String content = strArr[1];
        if (Strings.isNullOrEmpty(target) || Strings.isNullOrEmpty(content)){
            System.out.println("对象或内容为空，请重新发送 ChatSomeone 指令");
            return;
        }
        //打包成protobuf格式
        MsgChatInfoProto.RequestChatInfo requestChatInfo = MsgChatInfoProto.RequestChatInfo.newBuilder()
                .setType(MsgChatInfoProto.RequestType.CHATSOMEONE)
                .setTarget(target)
                .setContent(content)
                .build();
        //输出
        channel.writeAndFlush(requestChatInfo);
    }

}
