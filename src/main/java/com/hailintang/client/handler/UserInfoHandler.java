package com.hailintang.client.handler;

import com.hailintang.client.local.ContentType;
import com.hailintang.client.local.LocalUserData;
import com.hailintang.client.protobuf.protoc.MsgUserInfoProto;
import com.hailintang.client.protobuf.protoc.RoleProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import sun.misc.IOUtils;

/**
 * @ClassName UserInfoHandler
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/8 9:48
 * @Version 1.0
 */
public class UserInfoHandler extends SimpleChannelInboundHandler<MsgUserInfoProto.ResponseUserInfo> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgUserInfoProto.ResponseUserInfo responseUserInfo) throws Exception {
        // 先输出返回的消息
        System.out.println(responseUserInfo.getContent());
        int result = responseUserInfo.getResult();

        boolean flag = result==1?true:false;
        if(responseUserInfo.getType().equals(MsgUserInfoProto.RequestType.LOGIN)&&responseUserInfo.getContent().equals(ContentType.UNCREATE_ROLE)){
            System.out.println(roleType());
        }
        // 如果是login register的response，将userId记录到本地
        else if (responseUserInfo.getType().equals(MsgUserInfoProto.RequestType.LOGIN)&&flag){
            RoleProto.Role role = responseUserInfo.getRole();

            //设置用户id
            LocalUserData.setUserId(responseUserInfo.getUserId());

            //输出
            System.out.println("角色："+role.getName()+"上线了");
        } else if (responseUserInfo.getType().equals(MsgUserInfoProto.RequestType.REGISTER)){
            System.out.println("成功注册用户，用户登录 Login");
        } else if (responseUserInfo.getType().equals(MsgUserInfoProto.RequestType.EXIT)){
            System.out.println("成功退出游戏");
            LocalUserData.setUserId(0);
            System.exit(0);
        }
    }

    public String roleType(){
        String msg = "请继续注册游戏角色(ChooseRole)"+";\n"
                +"职业描述:\n"
                +"1、战士:高物理攻击和高防御，可以使用嘲讽技能，成为BOSS优先攻击的目标\n"
                +"2、牧师:带有治疗的职业，强力的治疗技能需要有吟唱时间\n"
                +"3、法师:群体法术伤害，可以攻击复数单位\n"
                +"4、召唤师:能召唤召唤兽协助战斗。宝宝也能释放技能，而且玩家切换场景的时候自动跟随，玩家收到攻击或主动攻击，宝宝也会释放技能。\n";
        return msg;
    }
}
