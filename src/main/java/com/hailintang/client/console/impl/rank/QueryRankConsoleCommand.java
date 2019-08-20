package com.hailintang.client.console.impl.rank;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgAuctionInfoProto;
import com.hailintang.client.protobuf.protoc.MsgRankInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName QueryRankConsoleCommand
 * @Description 查询排行榜
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class QueryRankConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        MsgRankInfoProto.RequestRankInfo requestRankInfo = MsgRankInfoProto.RequestRankInfo.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setType(MsgRankInfoProto.RequestType.QUERYRANK)
                .build();

        channel.writeAndFlush(requestRankInfo);
    }
}
