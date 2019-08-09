package com.hailintang.client.console;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleCommandManager implements ConsoleCommand {

    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager(){
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("Login", new LoginConsoleCommand());
        consoleCommandMap.put("Register", new RegisterConsoleCommand());
        consoleCommandMap.put("ChooseRole", new ChooseRoleConsoleCommand());
        consoleCommandMap.put("GetMap",new GetMapConsoleCommand());
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