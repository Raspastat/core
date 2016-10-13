package com.shepherdjerred.thermostat.core.thermometer;

import com.pi4j.wiringpi.Gpio;

public class Thermometer {

    private int currentTemp;

    public Thermometer() {
        enableThermometer();
        updateTemp();
    }

    private void enableThermometer() {
        System.out.println("Pin 4 set to INPUT");
        Gpio.pinMode(4, Gpio.INPUT);
    }

    public void updateTemp() {
        System.out.println("Updating temperature..");
        int temp = Gpio.digitalRead(4);
        currentTemp = temp;
        System.out.println("Current temp: " + temp);
    }

    public int getTemp() {
        return currentTemp;
    }

}
