package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgBossInfoProto;
import com.hailintang.client.protobuf.protoc.MsgEquipInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName GetGoodsConsoleCommand
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class AttackBossConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入boss名称,地图名称，技能名称(bossName,mapName,skillName)");
        String attack = scanner.next();

        if (Strings.isNullOrEmpty(attack)){
            System.out.println("尚未指令，请重新发送 AttackBoss 指令");
            return;
        }
        // 解析输入的字符串，分割为两个参数
        String[] strArr = attack.split(",");
        if (strArr.length != 3){
            System.out.println("输入的参数有误，请重新发送 AttackBoss 指令");
            return;
        }
        String bossName = strArr[0];
        String mapName = strArr[1];
        String skillName = strArr[2];
        if (Strings.isNullOrEmpty(bossName) || Strings.isNullOrEmpty(mapName)||Strings.isNullOrEmpty(skillName)){
            System.out.println("boss名称或地图名称或技能名称为空，请重新发送 AttackBoss 指令");
            return;
        }
        //打包成protobuf格式
        MsgBossInfoProto.RequestBossInfo requestBossInfo = MsgBossInfoProto.RequestBossInfo.newBuilder()
                .setType(MsgBossInfoProto.RequestType.ATTACKBOSS)
                .setBossName(bossName)
                .setMapName(mapName)
                .setSkillName(skillName)
                .build();
        //输出
        channel.writeAndFlush(requestBossInfo);
    }
}
