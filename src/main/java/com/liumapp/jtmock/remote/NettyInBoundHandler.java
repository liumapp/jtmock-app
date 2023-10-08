package com.liumapp.jtmock.remote;

import com.liumapp.jtmock.factory.CustomBeanFactory;
import com.liumapp.jtmock.view.HandPanel;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 * @file NettyInBoundHandler.java
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2023/10/7 16:59
 */
@ChannelHandler.Sharable
public class NettyInBoundHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private static final Logger logger = LoggerFactory.getLogger(NettyTcpClient.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        HandPanel handPanel = CustomBeanFactory.getHandPanel();
        JTextPane jTextPane = handPanel.getTextPane1();
        String text = jTextPane.getText();
        text = text + "\n" + "接收到服务端数据:" + ByteBufUtil.hexDump(msg);
        jTextPane.setText(text);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }
}
