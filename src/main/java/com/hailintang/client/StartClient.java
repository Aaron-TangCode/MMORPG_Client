package com.hailintang.client;

import com.hailintang.client.console.ConsoleCommandManager;
import com.hailintang.client.console.LoginConsoleCommand;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @ClassName StartClient
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/7 16:27
 * @Version 1.0
 */
@Component
public class StartClient {
    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static void main(String[] args) {
        Client client = applicationContext.getBean(Client.class);
        client.start();
        System.out.println("欢迎进入游戏！登录:Login\t\t注册:Register\t\t帮助文档:Help");
        //控制中心
        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        //控制台
        Scanner scanner = new Scanner(System.in);
        //
        while (scanner.hasNext()){

                consoleCommandManager.exec(scanner, client.getChannel());

        }
    }
}
