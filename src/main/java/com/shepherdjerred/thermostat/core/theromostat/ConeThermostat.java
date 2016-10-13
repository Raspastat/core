package com.shepherdjerred.thermostat.core.theromostat;

public class ConeThermostat implements Thermostat {

    private Mode mode;

    public ConeThermostat() {
        mode = Mode.OFF;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        System.out.println("Mode changed to " + mode.toString());
        this.mode = mode;
        updateThermostatSettings();
    }

    // We do the physical stuff here, signaling the AC
    public void updateThermostatSettings() {
        switch (mode) {
            case COOL:
                break;
            case HEAT:
                break;
            case OFF:
                break;
        }
    }

}
