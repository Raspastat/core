package com.shepherdjerred.thermostat.core.thermometer;

import com.pi4j.wiringpi.Gpio;

public class Thermometer {

    private int currentTemp;

    public Thermometer() {
        enableThermometer();
        updateTemp();
    }

    private void enableThermometer() {
        Gpio.pinMode(4, Gpio.INPUT);
    }

    public void updateTemp() {
        int temp = Gpio.digitalRead(4);
        currentTemp = temp;
        System.out.println(temp);
    }

    public int getTemp() {
        return currentTemp;
    }

}
