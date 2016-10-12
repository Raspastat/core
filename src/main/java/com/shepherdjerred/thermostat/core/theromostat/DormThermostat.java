package com.shepherdjerred.thermostat.core.theromostat;

import com.shepherdjerred.thermostat.core.pi.GpioWrapper;

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
        if (on) {
            if (mode == Mode.HEAT) {
                GpioWrapper.getCooling().low();
                GpioWrapper.getHeating().high();
            } else {
                GpioWrapper.getHeating().low();
                GpioWrapper.getCooling().high();
            }
        } else {
            GpioWrapper.getHeating().low();
            GpioWrapper.getCooling().low();
        }
    }

}
