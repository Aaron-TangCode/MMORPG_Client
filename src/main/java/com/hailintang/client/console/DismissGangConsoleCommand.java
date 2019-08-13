package com.hailintang.client.console;

import com.google.common.base.Strings;
import com.hailintang.client.protobuf.protoc.MsgGangInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName GetGoodsConsoleCommand
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class DismissGangConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("确认解散工会？YSE/NO");
        String flag = scanner.next();

        if (Strings.isNullOrEmpty(flag)){
            System.out.println("尚未指令，请重新发送 DismissGang 指令");
            return;
        }

        //打包成protobuf格式
        MsgGangInfoProto.RequestGangInfo requestGangInfo = MsgGangInfoProto.RequestGangInfo.newBuilder()
                .setGangName(flag)
                .setType(MsgGangInfoProto.RequestType.DISMISSGANG)
                .build();
        //输出
        channel.writeAndFlush(requestGangInfo);
    }
}
