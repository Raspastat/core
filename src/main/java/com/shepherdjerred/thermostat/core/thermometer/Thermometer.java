package com.shepherdjerred.thermostat.core.thermometer;

public class Thermometer {

    private int currentTemp;

    public Thermometer() {
        updateTemp();
    }

    public void updateTemp() {
        // TODO Get the actual current temp from the thermometer
        currentTemp = 70;
    }

    public int getTemp() {
        return currentTemp;
    }

}
