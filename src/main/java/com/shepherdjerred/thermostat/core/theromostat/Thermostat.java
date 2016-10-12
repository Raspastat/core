package com.shepherdjerred.thermostat.core.theromostat;

public interface Thermostat {

    void setMode(Mode mode);
    void setOn(boolean on);
    void updateThermostatSettings();

    enum Mode {
        HEAT, COOL
    };

}
