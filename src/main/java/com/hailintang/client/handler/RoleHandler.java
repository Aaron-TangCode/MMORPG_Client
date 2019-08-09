package com.hailintang.client.handler;

import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static com.hailintang.client.local.RequestRoleInfoType.CHOOSEROLE;
import static com.hailintang.client.local.RequestRoleInfoType.ROLEINFO;

/**
 * @ClassName RoleHandler
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/9 10:53
 * @Version 1.0
 */
public class RoleHandler extends SimpleChannelInboundHandler<MsgRoleInfoProto.ResponseRoleInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgRoleInfoProto.ResponseRoleInfo responseRoleInfo) throws Exception {
        //输出响应内容
        final String content = responseRoleInfo.getContent();
        System.out.println(content);
        //相应操作
        int typeNum = responseRoleInfo.getType().getNumber();

        switch (typeNum) {
            case CHOOSEROLE :
                System.out.println("欢迎进入游戏世界......");
                break;
            case ROLEINFO:
                System.out.println("继续操作......");
                break;
                default:
                    break;
        }
    }
}
