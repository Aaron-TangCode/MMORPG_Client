package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgUserInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName RegisterConsoleCommand
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/8 16:47
 * @Version 1.0
 */
public class RegisterConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请注册用户账号：（username,password）");

        String accountInfo = scanner.next();

        if (Strings.isNullOrEmpty(accountInfo)){
            System.out.println("尚未输入账号信息，请重新发送 register 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = accountInfo.split(",");
        String username = strArr[0];
        String password = strArr[1];
        if (Strings.isNullOrEmpty(username) || Strings.isNullOrEmpty(password)){
            System.out.println("账号名或密码为空，请重新发送 register 指令");
            return;
        }

        MsgUserInfoProto.RequestUserInfo requestUserInfo = MsgUserInfoProto.RequestUserInfo.newBuilder()
                .setType(MsgUserInfoProto.RequestType.REGISTER)
                .setUsername(username)
                .setPassword(password)
                .setRequestId(UUID.randomUUID().toString())
                .build();

        channel.writeAndFlush(requestUserInfo);
    }
}
