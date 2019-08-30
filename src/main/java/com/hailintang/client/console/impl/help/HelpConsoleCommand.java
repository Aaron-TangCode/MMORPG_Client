package com.hailintang.client.console.impl.help;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgEquipInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName HelpConsoleCommand
 * @Description 帮助文档
 * @Author DELL
 * @Date 2019/8/12 12:02
 * @Version 1.0
 */
public class HelpConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        StringBuilder sb = new StringBuilder("游戏的指令有：\n");
        //user
        sb.append("用户相关：\n");
        sb.append("\t Login：登录\n");
        sb.append("\t Register：注册\n");
        //role
        sb.append("角色相关：\n");
        sb.append("\t ChooseRole：创建角色\n");
        sb.append("\t RoleInfo：获取角色信息\n");
        sb.append("\t UseGoods：角色使用物品\n");
        //map
        sb.append("场景相关：\n");
        sb.append("\t GetMap：获取角色当前所在地图\n");
        sb.append("\t Move：角色移动，切换地图\n");
        //npc
        sb.append("NPC相关：\n");
        sb.append("\t TalkToNpc：和NPC谈话\n");
        //goods
        sb.append("背包相关：\n");
        sb.append("\t GetGoods：获取物品或装备\n");
        sb.append("\t DiscardGoods：丢弃物品或装备\n");
        sb.append("\t ShowGoods：显示玩家装备或物品\n");
        //skill
        sb.append("技能相关：\n");
        sb.append("\t UpgradeSkill：升级技能\n");
        sb.append("\t StudySkill：学习新技能\n");
        sb.append("\t RolePK：角色PK\n");
        //equip
        sb.append("装备相关：\n");
        sb.append("\t AddEquip：装备武器\n");
        sb.append("\t RemoveEquip：移除武器\n");
        sb.append("\t ShowEquip：展示武器\n");
        //duplicate
        sb.append("副本相关：\n");
        sb.append("\t EnterDuplicate：（单人）进入副本\n");
        sb.append("\t TeamEnterDuplicate：（组队）进入副本\n");
        sb.append("\t QueryTeam：查询队伍\n");
        sb.append("\t CreateTeam：创建队伍\n");
        sb.append("\t JoinTeam：加入队伍\n");
        sb.append("\t ExitTeam：退出队伍\n");
        sb.append("\t DismissTeam：解散队伍\n");
        sb.append("\t UseSkillAttackBoss：使用技能攻击boss\n");
        //shop
        sb.append("商店相关：\n");
        sb.append("\t Buy：购买装备或物品\n");
        //chat
        sb.append("聊天相关：\n");
        sb.append("\t ChatAll：世界聊天\n");
        sb.append("\t ChatSomeone：私聊\n");
        //email
        sb.append("邮件相关：\n");
        sb.append("\t SendGoods：发送物品或装备\n");

        //trade
        sb.append("交易相关：\n");
        sb.append("\t TradeGoods：交易\n");
        sb.append("\t RequestTrade：请求交易\n");
        sb.append("\t ConfirmTrade：确认交易\n");
        sb.append("\t TradingGoods：交易物品\n");
        sb.append("\t TradingMoney：交易金额\n");

        //gang
        sb.append("工会相关：\n");
        sb.append("\t CreateGang：创建工会\n");
        sb.append("\t JoinGang：加入工会\n");
        sb.append("\t DismissGang：解散工会\n");
        sb.append("\t DonateMoney：捐钱\n");
        //auction
        sb.append("拍卖行相关：\n");
        sb.append("\t Bidding：竞拍物品\n");
        sb.append("\t Recycle：物品下架\n");
        sb.append("\t Publish：物品上架\n");
        sb.append("\t QueryAuction：查询拍卖行物品\n");
        //rank
        sb.append("排行榜相关：\n");
        sb.append("\t QueryRank：排行榜\n");

        sb.append("退出游戏相关：\n");
        sb.append("\t Exit：退出当前游戏\n");

        sb.append("任务相关：\n");
        sb.append("\t QueryReceivableTask：查询可接受任务\n");
        sb.append("\t QueryReceivedTask：查询已接受任务\n");
        sb.append("\t ReceiveTask：接受任务\n");
        sb.append("\t DiscardTask：放弃任务\n");

        System.out.println(sb.toString());
    }
}
