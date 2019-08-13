package com.hailintang.client;

import com.hailintang.client.codec.CustomProtobufDecoder;
import com.hailintang.client.codec.CustomProtobufEncoder;
import com.hailintang.client.handler.*;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

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
    }
}
