package com.shepherdjerred.thermostat.core.theromostat;

import com.shepherdjerred.thermostat.core.Main;

public class ConeThermostat implements Thermostat {

    private Mode mode;

    public ConeThermostat() {
        mode = Mode.OFF;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        Main.getLogger().info("\n\n" + "Mode changed to " + mode.toString() + "\n");
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
