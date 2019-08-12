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
        consoleCommandMap.put("StudySKill",new StudySkillConsoleCommand());
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