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
        System.out.println("欢迎进入游戏！登录:Login\t\t注册:Register");

        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            // 判断channel中是否属于登录状态
//            if(LocalUserData.getUserId()<=0){
//                // 如果为检测到channel中的session，那么调用登录控制台
//                loginConsoleCommand.exec(scanner, client.getChannel());
//            }else{
                // 否则，根据指令调用相应的控制台
                consoleCommandManager.exec(scanner, client.getChannel());
//            }

        }
    }
}
