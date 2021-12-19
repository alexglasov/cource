package com.example.demo.common;

import org.springframework.beans.factory.annotation.Value;

public class DbProperties {
    @Value("db.properties.url")
    private static String url;
    @Value("db.properties.user")
    private static String user;
    @Value("db.properties.password")
    private static String password;
    @Value("db.properties.driver")
    private static String driver;

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
