package com.liumapp.jtmock.config;

/**
 * @file MockProperties.java
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2023/10/7 14:47
 */
public class MockProperties {

    private String ip;

    private Integer port;

    public MockProperties() {
    }

    public MockProperties(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
