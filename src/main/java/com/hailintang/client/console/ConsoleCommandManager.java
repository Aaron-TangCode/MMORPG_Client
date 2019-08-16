package com.hailintang.client.console;

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
        //skill
        consoleCommandMap.put("UpgradeSkill",new UpgradeSkillConsoleCommand());
        consoleCommandMap.put("StudySkill",new StudySkillConsoleCommand());
        consoleCommandMap.put("RolePK",new RolePKConsoleCommand());
        consoleCommandMap.put("UseSkill",new UseSkillConsoleCommand());
        //equip
        consoleCommandMap.put("AddEquip",new AddEquipConsoleCommand());
        consoleCommandMap.put("RemoveEquip",new RemoveEquipConsoleCommand());
        //duplicate
        consoleCommandMap.put("AttackBoss",new AttackBossConsoleCommand());
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