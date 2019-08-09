package com.hailintang.client.utils;

import com.hailintang.client.protobuf.protoc.MsgUserInfoProto;
import io.netty.channel.Channel;

import java.util.UUID;

/**
 * @ClassName ProtobufUtil
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/9 18:35
 * @Version 1.0
 */
public class ProtobufUtil {
    public static void send(Channel channel, IProto iProto) {

        //编码
        byte[] result = iProto.encode();

        //打包成protobuf格式
//        MsgUserInfoProto.RequestUserInfo requestUserInfo = MsgUserInfoProto.RequestUserInfo.newBuilder()
//                .setRequestId(UUID.randomUUID().toString())
//                .setType(MsgUserInfoProto.RequestType.LOGIN)
//                .setUsername(username)
//                .setPassword(password)
//                .build();
//        channel.writeAndFlush(requestUserInfo);
    }
}
