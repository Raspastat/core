package com.shepherdjerred.thermostat.core.pi;

import com.pi4j.wiringpi.Gpio;

public class GpioWrapper {

    static {
        Gpio.wiringPiSetup();
    }

}
