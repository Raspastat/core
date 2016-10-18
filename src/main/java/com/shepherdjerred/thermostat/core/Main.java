package com.shepherdjerred.thermostat.core;

public class Main {

    public static void main(String[] args) {
        System.out.println("thermostat-core starting...");
        new Cli().setup();
        new Logger().setupLogging();
    }

    public static void stop() {
        System.exit(0);
    }

}
