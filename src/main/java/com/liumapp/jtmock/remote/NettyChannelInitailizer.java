package com.liumapp.jtmock.remote;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

/**
 * @file NettyChannelInitailizer.java
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2023/10/7 16:45
 */
public class NettyChannelInitailizer extends ChannelInitializer<SocketChannel> {

    private SimpleChannelInboundHandler<ByteBuf> inboundHandler;

    public NettyChannelInitailizer(SimpleChannelInboundHandler<ByteBuf> inboundHandler) {
        this.inboundHandler = inboundHandler;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(inboundHandler);
    }

}
