package com.hailintang.client.console.impl.role;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName RoleInfoConsoleCommand
 * @Description 获取角色信息
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class RoleInfoConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        MsgRoleInfoProto.RequestRoleInfo requestRoleInfo = MsgRoleInfoProto.RequestRoleInfo.newBuilder()
                .setType(MsgRoleInfoProto.RequestType.ROLEINFO)
                .setRequestId(UUID.randomUUID().toString())
                .build();

        channel.writeAndFlush(requestRoleInfo);
    }
}
