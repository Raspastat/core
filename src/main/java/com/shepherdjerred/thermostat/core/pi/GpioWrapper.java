package com.shepherdjerred.thermostat.core.pi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;

public class GpioWrapper {

    final static GpioController gpio = GpioFactory.getInstance();

    public static GpioController getGpio() {
        return gpio;
    }
}
