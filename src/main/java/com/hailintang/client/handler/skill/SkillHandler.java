package com.hailintang.client.handler.skill;

import com.hailintang.client.protobuf.protoc.MsgSkillInfoProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static com.hailintang.client.local.RequestSkillInfoType.UPGRADESKILL;

/**
 * @ClassName SkillHandler
 * @Description 技能处理器
 * @Author DELL
 * @Date 2019/8/12 15:30
 * @Version 1.0
 */
public class SkillHandler extends SimpleChannelInboundHandler<MsgSkillInfoProto.ResponseSkillInfo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgSkillInfoProto.ResponseSkillInfo responseSkillInfo) throws Exception {
        System.out.println(responseSkillInfo.getContent());
    }
}
