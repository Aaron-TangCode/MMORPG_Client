package com.hailintang.client.handler.role;

import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import com.hailintang.client.protobuf.protoc.RoleProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static com.hailintang.client.local.RequestRoleInfoType.*;

/**
 * @ClassName RoleHandler
 * @Description 角色处理器
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
                System.out.println("成功注册角色，请重新登录......");
                break;
            case ROLEINFO:
                RoleProto.Role role = responseRoleInfo.getRole();
                System.out.println("成功获取玩家信息......");
                System.out.println("当前总血量/总血量："+role.getCurHp()+"/"+role.getTotalHp()+"\t当前魔法值/总魔法值："+role.getCurMp()+"/"+role.getTotalMp()
                        +"\t攻击力："+role.getAttack()+"\t防御力："+role.getDefend());
                break;
            case USEGOODS :
                //没操作
                default:
                    break;
        }
    }
}
