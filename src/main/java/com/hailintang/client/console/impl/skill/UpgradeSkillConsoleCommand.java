package com.hailintang.client.console.impl.skill;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgGoodsInfoProto;
import com.hailintang.client.protobuf.protoc.MsgSkillInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName UpgradeSkillConsoleCommand
 * @Description 升级技能
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class UpgradeSkillConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入技能名称");
        String skillName = scanner.next();

        if (Strings.isNullOrEmpty(skillName)){
            System.out.println("尚未指令，请重新发送 UpgradeSkill 指令");
            return;
        }

        //打包成protobuf格式
        MsgSkillInfoProto.RequestSkillInfo requestSkillInfo = MsgSkillInfoProto.RequestSkillInfo.newBuilder()
                .setType(MsgSkillInfoProto.RequestType.UPGRADESKILL)
                .setRequestId(UUID.randomUUID().toString())
                .setSkillName(skillName)
                .build();
        //输出
        channel.writeAndFlush(requestSkillInfo);
    }
}
