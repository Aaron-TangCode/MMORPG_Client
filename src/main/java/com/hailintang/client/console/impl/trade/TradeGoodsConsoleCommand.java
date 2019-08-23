package com.hailintang.client.console.impl.trade;

import com.google.common.base.Strings;
import com.hailintang.client.console.ConsoleCommand;
import com.hailintang.client.protobuf.protoc.MsgRoleInfoProto;
import com.hailintang.client.protobuf.protoc.MsgTradeInfoProto;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName TradeGoodsConsoleCommand
 * @Description 交易物品
 * @Author DELL
 * @Date 2019/8/8 21:23
 * @Version 1.0
 */
public class TradeGoodsConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        //提示信息
        System.out.println("交易流程：RequestTrade-ConfirmTrade-TradingGoods or TradingMoney");
    }
}
