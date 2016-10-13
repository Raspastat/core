package com.shepherdjerred.thermostat.core;

import com.shepherdjerred.thermostat.core.pi.GpioWrapper;
import com.shepherdjerred.thermostat.core.scheduling.Scheduler;
import com.shepherdjerred.thermostat.core.thermometer.DHT11;
import com.shepherdjerred.thermostat.core.theromostat.ConeThermostat;
import com.shepherdjerred.thermostat.core.theromostat.Thermostat;

public class Main {

    private static GpioWrapper gpioWrapper;
    private static Controller controller;

    public static void main(String[] args) {
        System.out.println("thermostat-core starting...");
        init();
    }

    public static void init() {
        gpioWrapper = new GpioWrapper();
        controller = new Controller(new ConeThermostat(), new DHT11(3, 500), new Scheduler(73));
    }

    public static Controller getController() {
        return controller;
    }

    public static GpioWrapper getGpioWrapper() {
        return gpioWrapper;
    }

}
