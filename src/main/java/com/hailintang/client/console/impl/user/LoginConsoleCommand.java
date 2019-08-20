package com.hailintang.client.console.impl.user;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
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
public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        // 读取输入
        System.out.println("输入用户名，密码登录：(username,password)");
        String accountInfo = scanner.next();
        if (Strings.isNullOrEmpty(accountInfo)){
            System.out.println("尚未输入账号信息，请重新发送 login 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = accountInfo.split(",");
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
//        ProtobufUtil.send(channel);
        //打包成protobuf格式
        MsgUserInfoProto.RequestUserInfo requestUserInfo = MsgUserInfoProto.RequestUserInfo.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setType(MsgUserInfoProto.RequestType.LOGIN)
                .setUsername(username)
                .setPassword(password)
                .build();
        //输出
        channel.writeAndFlush(requestUserInfo);

        //等待消息响应
        waitForLoginResponse();
    }

    /**
     * 暂时先等待消息返回，防止新开thread直接读取指令了
     */
    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
