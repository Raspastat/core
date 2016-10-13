package com.shepherdjerred.thermostat.core.pi;

import com.pi4j.wiringpi.Gpio;

public class GpioWrapper {

    public GpioWrapper() {
        Gpio.wiringPiSetup();
    }
}
