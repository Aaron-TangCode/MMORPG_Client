package com.hailintang.client.console;

import com.google.common.base.Strings;
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
            System.out.println("尚未输入账号信息，请重新发送 login 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = desc.split(",");
        if (strArr.length != 2){
            System.out.println("输入的参数有误，请重新发送 login 指令");
            return;
        }
        String username = strArr[0];
        String password = strArr[1];
        if (Strings.isNullOrEmpty(username) || Strings.isNullOrEmpty(password)){
            System.out.println("账号名或密码为空，请重新发送 login 指令");
            return;
        }
        //打包成protobuf格式
        MsgUserInfoProto.RequestUserInfo requestUserInfo = MsgUserInfoProto.RequestUserInfo.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setType(MsgUserInfoProto.RequestType.LOGIN)
                .setUsername(username)
                .setPassword(password)
                .build();
        //输出
        channel.writeAndFlush(requestUserInfo);
    }
}
