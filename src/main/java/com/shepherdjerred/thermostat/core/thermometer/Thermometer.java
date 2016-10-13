package com.shepherdjerred.thermostat.core.thermometer;

import com.pi4j.wiringpi.Gpio;

public interface Thermometer {

    void enable();
    void updateTemp();
    float getTemp();
    float getHumidity();

}
