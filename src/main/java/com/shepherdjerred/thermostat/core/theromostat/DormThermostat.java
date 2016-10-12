package com.shepherdjerred.thermostat.core.theromostat;

public class DormThermostat implements Thermostat {

    private Mode mode;
    private boolean on;

    public DormThermostat() {
        mode = Mode.COOL;
        on = false;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        if (on)
            updateThermostatSettings();
    }

    public void setOn(boolean on) {
        this.on = on;
        updateThermostatSettings();
    }

    public void updateThermostatSettings() {
        // Use the current mode & enable the thermostat
        if (mode == Mode.HEAT) {
            // Enable heating
        } else {
            // Enable cooling
        }
    }

}
