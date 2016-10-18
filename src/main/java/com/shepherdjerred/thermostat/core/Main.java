package com.shepherdjerred.thermostat.core;

import com.shepherdjerred.thermostat.core.redis.JedisManager;

public class Main {

    public static void main(String[] args) {
        System.out.println("thermostat-core starting...");
        new Cli().setup();
        new Logger().setupLogging();
        new JedisManager();
    }

    public static void stop() {
        System.exit(0);
    }

}
