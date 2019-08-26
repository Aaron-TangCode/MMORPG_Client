package com.hailintang.client.console;

import com.hailintang.client.console.impl.auction.BiddingConsoleCommand;
import com.hailintang.client.console.impl.auction.PublishConsoleCommand;
import com.hailintang.client.console.impl.auction.QueryAuctionConsoleCommand;
import com.hailintang.client.console.impl.auction.RecycleConsoleCommand;
import com.hailintang.client.console.impl.chat.ChatAllConsoleCommand;
import com.hailintang.client.console.impl.chat.ChatSomeoneConsoleCommand;
import com.hailintang.client.console.impl.duplicate.*;
import com.hailintang.client.console.impl.email.SendGoodsConsoleCommand;
import com.hailintang.client.console.impl.equip.AddEquipConsoleCommand;
import com.hailintang.client.console.impl.equip.RemoveEquipConsoleCommand;
import com.hailintang.client.console.impl.equip.ShowEquipConsoleCommand;
import com.hailintang.client.console.impl.exit.ExitConsoleCommand;
import com.hailintang.client.console.impl.gang.CreateGangConsoleCommand;
import com.hailintang.client.console.impl.gang.DismissGangConsoleCommand;
import com.hailintang.client.console.impl.gang.DonateMoneyConsoleCommand;
import com.hailintang.client.console.impl.gang.JoinGangConsoleCommand;
import com.hailintang.client.console.impl.goods.DiscardGoodsConsoleCommand;
import com.hailintang.client.console.impl.goods.GetGoodsConsoleCommand;
import com.hailintang.client.console.impl.goods.ShowGoodsConsoleCommand;
import com.hailintang.client.console.impl.help.HelpConsoleCommand;
import com.hailintang.client.console.impl.map.GetMapConsoleCommand;
import com.hailintang.client.console.impl.map.MoveConsoleCommand;
import com.hailintang.client.console.impl.npc.TalkToNpcConsoleCommand;
import com.hailintang.client.console.impl.rank.QueryRankConsoleCommand;
import com.hailintang.client.console.impl.role.ChooseRoleConsoleCommand;
import com.hailintang.client.console.impl.role.RoleInfoConsoleCommand;
import com.hailintang.client.console.impl.role.UseGoodsConsoleCommand;
import com.hailintang.client.console.impl.shop.BuyConsoleCommand;
import com.hailintang.client.console.impl.skill.RolePKConsoleCommand;
import com.hailintang.client.console.impl.skill.StudySkillConsoleCommand;
import com.hailintang.client.console.impl.skill.UpgradeSkillConsoleCommand;
import com.hailintang.client.console.impl.skill.UseSkillConsoleCommand;
import com.hailintang.client.console.impl.task.DiscardTaskConsoleCommand;
import com.hailintang.client.console.impl.task.QueryReceivableTaskConsoleCommand;
import com.hailintang.client.console.impl.task.QueryReceivedTaskConsoleCommand;
import com.hailintang.client.console.impl.task.ReceiveTaskConsoleCommand;
import com.hailintang.client.console.impl.trade.*;
import com.hailintang.client.console.impl.user.LoginConsoleCommand;
import com.hailintang.client.console.impl.user.RegisterConsoleCommand;
import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleCommandManager implements ConsoleCommand {

    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager(){
        consoleCommandMap = new HashMap<>();
        //user
        consoleCommandMap.put("Login", new LoginConsoleCommand());
        consoleCommandMap.put("Register", new RegisterConsoleCommand());
        //role
        consoleCommandMap.put("ChooseRole", new ChooseRoleConsoleCommand());
        consoleCommandMap.put("RoleInfo", new RoleInfoConsoleCommand());
        consoleCommandMap.put("UseGoods",new UseGoodsConsoleCommand());
        //map
        consoleCommandMap.put("GetMap",new GetMapConsoleCommand());
        consoleCommandMap.put("Move",new MoveConsoleCommand());
        //npc
        consoleCommandMap.put("TalkToNpc",new TalkToNpcConsoleCommand());
        //goods
        consoleCommandMap.put("GetGoods",new GetGoodsConsoleCommand());
        consoleCommandMap.put("DiscardGoods",new DiscardGoodsConsoleCommand());
        consoleCommandMap.put("ShowGoods",new ShowGoodsConsoleCommand());
        //skill
        consoleCommandMap.put("UpgradeSkill",new UpgradeSkillConsoleCommand());
        consoleCommandMap.put("StudySkill",new StudySkillConsoleCommand());
        consoleCommandMap.put("RolePK",new RolePKConsoleCommand());
        //equip
        consoleCommandMap.put("AddEquip",new AddEquipConsoleCommand());
        consoleCommandMap.put("RemoveEquip",new RemoveEquipConsoleCommand());
        consoleCommandMap.put("ShowEquip",new ShowEquipConsoleCommand());
        //duplicate
        consoleCommandMap.put("EnterDuplicate",new EnterDuplicateConsoleCommand());
        consoleCommandMap.put("TeamEnterDuplicate",new TeamEnterDuplicateConsoleCommand());
        consoleCommandMap.put("QueryTeam",new QueryTeamConsoleCommand());
        consoleCommandMap.put("CreateTeam",new CreateTeamConsoleCommand());
        consoleCommandMap.put("JoinTeam",new JoinTeamConsoleCommand());
        consoleCommandMap.put("ExitTeam",new ExitTeamConsoleCommand());
        consoleCommandMap.put("DismissTeam",new DismissTeamConsoleCommand());
        consoleCommandMap.put("UseSkillAttackBoss",new UseSkillAttackBossConsoleCommand());
        //shop
        consoleCommandMap.put("Buy",new BuyConsoleCommand());
        //chat
        consoleCommandMap.put("ChatAll",new ChatAllConsoleCommand());
        consoleCommandMap.put("ChatSomeone",new ChatSomeoneConsoleCommand());
        //email
        consoleCommandMap.put("SendGoods",new SendGoodsConsoleCommand());
        //trade
        consoleCommandMap.put("RequestTrade",new RequestTradeConsoleCommand());
        consoleCommandMap.put("ConfirmTrade",new ConfirmTradeConsoleCommand());
        consoleCommandMap.put("TradingGoods",new TradingGoodsConsoleCommand());
        consoleCommandMap.put("TradingMoney",new TradingMoneyConsoleCommand());
        consoleCommandMap.put("TradeGoods",new TradeGoodsConsoleCommand());
        //gang
        consoleCommandMap.put("CreateGang",new CreateGangConsoleCommand());
        consoleCommandMap.put("JoinGang",new JoinGangConsoleCommand());
        consoleCommandMap.put("DismissGang",new DismissGangConsoleCommand());
        consoleCommandMap.put("DonateMoney",new DonateMoneyConsoleCommand());
        //auction
        consoleCommandMap.put("Bidding",new BiddingConsoleCommand());
        consoleCommandMap.put("Recycle",new RecycleConsoleCommand());
        consoleCommandMap.put("Publish",new PublishConsoleCommand());
        consoleCommandMap.put("QueryAuction",new QueryAuctionConsoleCommand());
        //rank
        consoleCommandMap.put("QueryRank",new QueryRankConsoleCommand());
        //help
        consoleCommandMap.put("Help",new HelpConsoleCommand());
        //exit
        consoleCommandMap.put("Exit",new ExitConsoleCommand());
        //task
        consoleCommandMap.put("QueryReceivableTask",new QueryReceivableTaskConsoleCommand());
        consoleCommandMap.put("QueryReceivedTask",new QueryReceivedTaskConsoleCommand());
        consoleCommandMap.put("ReceiveTask",new ReceiveTaskConsoleCommand());
        consoleCommandMap.put("DiscardTask",new DiscardTaskConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        // 获取指令
        String command = scanner.next();

        // 获取指令对应的执行
        ConsoleCommand consoleCommand = consoleCommandMap.get(command);
        if (consoleCommand != null){
            consoleCommand.exec(scanner, channel);
        }else {
            System.err.println("无法识别["  + command + "]指令，请重新输入!");
        }
    }
}