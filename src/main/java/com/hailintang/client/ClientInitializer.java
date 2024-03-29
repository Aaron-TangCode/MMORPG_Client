package com.hailintang.client;

import com.hailintang.client.codec.CustomProtobufDecoder;
import com.hailintang.client.codec.CustomProtobufEncoder;
import com.hailintang.client.handler.auction.AuctionHandler;
import com.hailintang.client.handler.chat.ChatHandler;
import com.hailintang.client.handler.duplicate.DuplicateHandler;
import com.hailintang.client.handler.email.EmailHandler;
import com.hailintang.client.handler.equip.EquipHandler;
import com.hailintang.client.handler.gang.GangHandler;
import com.hailintang.client.handler.goods.GoodsHandler;
import com.hailintang.client.handler.map.MapHandler;
import com.hailintang.client.handler.npc.NpcHandler;
import com.hailintang.client.handler.rank.RankHandler;
import com.hailintang.client.handler.role.RoleHandler;
import com.hailintang.client.handler.shop.ShopHandler;
import com.hailintang.client.handler.skill.SkillHandler;
import com.hailintang.client.handler.task.TaskHandler;
import com.hailintang.client.handler.trade.TradeHandler;
import com.hailintang.client.handler.user.UserInfoHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @ClassName ClientInitializer
 * @Description TODO
 * @Author DELL
 * @Date 2019/5/2712:30
 * @Version 1.0
 */
public class ClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //heartbeat
        pipeline.addLast("serverIdleStateHandler",new ServerIdleStateHandler());

        pipeline.addLast("decoder",new CustomProtobufDecoder());
        pipeline.addLast("encoder",new CustomProtobufEncoder());

        // pipeline.addLast("clientHandler",new ClientHandler());
        //user
        pipeline.addLast("userInfoHandler",new UserInfoHandler());
        //role
        pipeline.addLast("roleHandler",new RoleHandler());
        //map
        pipeline.addLast("mapHandler",new MapHandler());
        //npc
        pipeline.addLast("npcHandler",new NpcHandler());
        //goods
        pipeline.addLast("goodsHandler",new GoodsHandler());
        //skill
        pipeline.addLast("skillHandler",new SkillHandler());
        //equip
        pipeline.addLast("equipHandler",new EquipHandler());
        //duplicate
        pipeline.addLast("duplicateHandler",new DuplicateHandler());
        //shop
        pipeline.addLast("shopHandler",new ShopHandler());
        //chat
        pipeline.addLast("chatHandler",new ChatHandler());
        //email
        pipeline.addLast("emailHandler",new EmailHandler());
        //trade
        pipeline.addLast("tradeHandler",new TradeHandler());
        //gang
        pipeline.addLast("gangHandler",new GangHandler());
        //auction
        pipeline.addLast("auctionHandler",new AuctionHandler());
        //rank
        pipeline.addLast("rankHandler",new RankHandler());
        //task
        pipeline.addLast("TaskHandler",new TaskHandler());
    }
}
