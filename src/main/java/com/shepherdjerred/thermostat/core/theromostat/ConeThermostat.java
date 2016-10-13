package com.shepherdjerred.thermostat.core.theromostat;

public class ConeThermostat implements Thermostat {

    private Mode mode;
    private boolean on;

    public ConeThermostat() {
        mode = Mode.COOL;
        on = false;
    }

    public Mode getMode() {
        return mode;
    }

    public boolean isOn() {
        return on;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        System.out.println("Mode changed to " + mode.toString());
        if (on)
            updateThermostatSettings();
    }

    public void setOn(boolean on) {
        System.out.println("On changed to " + on);
        this.on = on;
        updateThermostatSettings();
    }

    public void updateThermostatSettings() {
        if (on) {
            if (mode == Mode.HEAT) {
                // Cooling off, heat on
            } else {
                // Cooling on, heat off
            }
        } else {
            // Both off
        }
    }

}
