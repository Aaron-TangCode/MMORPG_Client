package com.hailintang.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName ConsoleCommand
 * @Description 用户控制台接口
 * @Author DELL
 * @Date 2019/8/8 10:29
 * @Version 1.0
 */
public interface ConsoleCommand {
    /**
     * 执行方法
     * @param scanner
     * @param channel
     */
    void exec(Scanner scanner, Channel channel);
}
