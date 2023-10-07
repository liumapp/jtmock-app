package com.liumapp.jtmock.remote;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @file NettyTcpClient.java
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2023/10/7 15:23
 */
public class NettyTcpClient {

    private static final Logger logger = LoggerFactory.getLogger(NettyTcpClient.class);

    private static final int THREAD_NUM = Math.min(4, Runtime.getRuntime().availableProcessors() * 2 + 1);

    private static final ScheduledThreadPoolExecutor scheduledExecutorService = new ScheduledThreadPoolExecutor(THREAD_NUM);

    /**
     * 重连心跳间隔
     */
    private static final long RECONNECT_TIME = TimeUnit.SECONDS.toMillis(5);

    private NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(THREAD_NUM);

    private ScheduledFuture<?> scheduledFuture;


    private Bootstrap bootstrap;

    private volatile Channel channel;

    private final Lock connectLock = new ReentrantLock();

    private ChannelInitializer channelInitializer;

    private InetSocketAddress address;

    private LocalDateTime lastConnectTime = LocalDateTime.now();

    private NettyTcpClient() {

    }

    public NettyTcpClient(InetSocketAddress address, ChannelInitializer channelInitializer) {
        this.address = address;
        this.channelInitializer = channelInitializer;
        try {
            doOpen();
        } catch (Throwable t) {
            logger.error("[doOpen] error", t);
        }
        try {
            connect();
        } catch (Throwable t) {
            logger.error("[connect] error", t);
        }
    }

    public NettyTcpClient(String host, int port, ChannelInitializer channelInitializer) {
        this(new InetSocketAddress(host, port), channelInitializer);
    }



    protected synchronized void initStatusCheckCommand() {
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            //状态检测
            scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(() -> {
                if (!isConnected()) {
                    try {
                        logger.warn("[netty-connect] netty will connect after 2s");
                        Thread.sleep(2000);
                        connect();
                    } catch (Throwable t) {
                        logger.error("[netty-connect] error,server:[{}:{}]", address.getHostString(), address.getPort(), t);
                    }
                }
            }, RECONNECT_TIME * 2, RECONNECT_TIME, TimeUnit.MILLISECONDS);
        }
    }

    protected synchronized void destroyStatusCheckCommand() {
        try {
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                scheduledFuture.cancel(true);
                scheduledExecutorService.purge();
            }
        } catch (Throwable t) {
            logger.error("destroyStatusCheckCommand error", t);
        }
    }

    public void doOpen() throws Throwable {
        bootstrap = new Bootstrap();
        bootstrap.group(nioEventLoopGroup)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .channel(NioSocketChannel.class);
        bootstrap.handler(channelInitializer);
    }


    public void connect() throws Throwable {
        connectLock.lock();
        try {
            if (isConnected()) {
                return;
            }
            initStatusCheckCommand();
            doConnect();

            if (isConnected()) {
                logger.info("success connect to server:[{}:{}] ", address.getHostString(), address.getPort());
            } else {
                logger.error("fail connect to server:[{}:{}] ", address.getHostString(), address.getPort());
            }
        } catch (Throwable t) {
            logger.error("connect to server:[{}:{}] error", address.getHostString(), address.getPort(), t);
        } finally {
            connectLock.unlock();
        }
    }

    public void close() throws Throwable {
        try {
            disConnect();
        } finally {
            if (nioEventLoopGroup != null) {
                try {
                    nioEventLoopGroup.shutdownGracefully();
                } catch (Throwable e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    public void disConnect() throws Throwable {
        connectLock.lock();
        try {
            destroyStatusCheckCommand();
            if (this.channel != null) {
                this.channel.close();
            }
        } finally {
            connectLock.unlock();
        }

    }

    protected void doConnect() throws Throwable {
        long start = System.currentTimeMillis();
        ChannelFuture future = bootstrap.connect(address.getHostString(), address.getPort()).sync();
        try {
            boolean ret = future.awaitUninterruptibly(3000, TimeUnit.MILLISECONDS);
            if (ret && future.isSuccess()) {
                Channel newChannel = future.channel();

                Channel oldChannel = this.channel;
                //关闭旧的连接
                if (oldChannel != null) {
                    logger.info("Close old netty channel {} on create new netty channel {}", oldChannel, newChannel);
                    oldChannel.close();
                }
                this.channel = newChannel;
                lastConnectTime = LocalDateTime.now();
                logger.info("lastConnectTime:{}", lastConnectTime.toString());
            } else if (future.cause() != null) {
                throw new RuntimeException("client failed to connect to server(address: " + address.getHostString() + ":" + address.getPort() + ") , error message is:" + future.cause().getMessage(), future.cause());
            } else {
                throw new RuntimeException("client failed to connect to server(address: " + address.getHostString() + ":" + address.getPort() + "), client-side timeout ms (elapsed: " + (System.currentTimeMillis() - start) + "ms) from netty client ");
            }
        } catch (Throwable e) {
            logger.error("error info:", e);
        } finally {
            if (!isConnected()) {
                future.cancel(true);
            }
        }

    }


    public boolean send(byte[] msg) {
        return send(Unpooled.copiedBuffer(msg));
    }


    public boolean send(String msg) {
        return send(msg.getBytes());
    }

    public boolean send(Object msg) {
        try {
            if (!isConnected()) {
                connect();
            }
            if (channel.isWritable()) {
                ChannelFuture future = channel.writeAndFlush(msg).sync();
                if (future.isSuccess()) {
                    return true;
                }
            }
        } catch (Throwable t) {
            logger.error("[send] error,server:[{}:{}]", address.getHostString(), address.getPort(), t);
        }
        return false;
    }


    public boolean send(Object msg, int retry) {
        while (retry-- > 0) {
            boolean flag = send(msg);
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public void reconnect() throws Throwable {
        disConnect();
        connect();
    }


    public boolean isConnected() {
        if (channel != null && channel.isActive()) {
            return true;
        }
        return false;
    }

    public Channel getChannel() {
        return channel;
    }
}

