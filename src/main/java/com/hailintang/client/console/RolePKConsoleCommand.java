package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgSkillInfoProto;
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
public class RolePKConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        // 读取输入
        System.out.println("输入技能名称，攻击对象：(skillName,target)");
        String rolePK = scanner.next();
        if (Strings.isNullOrEmpty(rolePK)){
            System.out.println("尚未输入信息，请重新发送 RolePK 指令");
            return;
        }

        // 解析输入的字符串，分割为两个参数
        String[] strArr = rolePK.split(",");
        if (strArr.length != 2){
            System.out.println("输入的参数有误，请重新发送 RolePK 指令");
            return;
        }
        String skillName = strArr[0];
        String target = strArr[1];
        if (Strings.isNullOrEmpty(skillName) || Strings.isNullOrEmpty(target)){
            System.out.println("技能名称或目标对象为空，请重新发送 RolePK 指令");
            return;
        }
        //打包成protobuf格式
        MsgSkillInfoProto.RequestSkillInfo requestSkillInfo = MsgSkillInfoProto.RequestSkillInfo.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setType(MsgSkillInfoProto.RequestType.ROLEPK)
                .setSkillName(skillName)
                .setTarget(target)
                .build();
        //输出
        channel.writeAndFlush(requestSkillInfo);
    }
}
