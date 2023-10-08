package com.liumapp.jtmock.factory;

import com.liumapp.jtmock.config.MockProperties;
import com.liumapp.jtmock.remote.NettyChannelInitailizer;
import com.liumapp.jtmock.remote.NettyTcpClient;
import com.liumapp.jtmock.view.HandPanel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @file CustomBeanFactory.java
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2023/10/7 17:29
 */
public class CustomBeanFactory {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");

    public static MockProperties getMockProperties() {
        return applicationContext.getBean(MockProperties.class);
    }

    public static NettyTcpClient getNettyTcpClient() {
        return applicationContext.getBean(NettyTcpClient.class);
    }

    public static NettyChannelInitailizer getNettyChannelInitailizer() {
        return applicationContext.getBean(NettyChannelInitailizer.class);
    }

    public static HandPanel getHandPanel() {
        return applicationContext.getBean(HandPanel.class);
    }




}
