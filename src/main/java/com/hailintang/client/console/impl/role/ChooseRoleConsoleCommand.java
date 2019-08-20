package com.hailintang.client.console.impl.role;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import com.hailintang.client.protobuf.protoc.MsgUserInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName ChooseRoleConsoleCommand
 * @Description 创建角色
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class ChooseRoleConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("请创建角色：（roleName,occupationId）");

        String accountInfo = scanner.next();

        if (Strings.isNullOrEmpty(accountInfo)){
            System.out.println("尚未输入信息，请重新发送 ChooseRole 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = accountInfo.split(",");
        String roleName = strArr[0];
        String occupationId = strArr[1];
        if (Strings.isNullOrEmpty(roleName) || Strings.isNullOrEmpty(occupationId)){
            System.out.println("角色名或职业id为空，请重新发送 ChooseRole 指令");
            return;
        }

        MsgRoleInfoProto.RequestRoleInfo requestRoleInfo = MsgRoleInfoProto.RequestRoleInfo.newBuilder()
                .setType(MsgRoleInfoProto.RequestType.CHOOSEROLE)
                .setRoleName(roleName)
                .setOccupationId(Integer.parseInt(occupationId))
                .setRequestId(UUID.randomUUID().toString())
                .build();

        channel.writeAndFlush(requestRoleInfo);
    }
}
