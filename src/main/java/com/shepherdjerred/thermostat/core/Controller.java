package com.shepherdjerred.thermostat.core;

import com.shepherdjerred.thermostat.core.scheduling.Scheduler;
import com.shepherdjerred.thermostat.core.thermometer.Thermometer;
import com.shepherdjerred.thermostat.core.theromostat.Thermostat;

public class Controller {

    private boolean enabled = true;
    private int tolerance = 3;
    private long updatePeriod = 1500;
    private int targetTemp;
    private Thermostat thermostat;
    private Thermometer thermometer;
    private Scheduler scheduler;

    public Controller(Thermostat thermostat, Thermometer thermometer, Scheduler scheduler) {
        this.thermostat = thermostat;
        this.thermometer = thermometer;
        this.scheduler = scheduler;
        targetTemp = scheduler.getDefaultTemp();
        thermometer.enable();
        thermostat.setOn(false);
        runTempLoop();
    }

    private void runTempLoop() {
        new Thread() {
            public void run() {
                while (enabled) {
                    thermometer.updateTemp();
                    if (thermometer.getTemp() < (targetTemp - tolerance) || thermometer.getTemp() > (targetTemp + tolerance)) {
                        if (thermometer.getTemp() < targetTemp) {
                            if (thermostat.getMode() != Thermostat.Mode.HEAT || !thermostat.isOn()) {
                                thermostat.setMode(Thermostat.Mode.HEAT);
                                thermostat.setOn(true);
                            }
                        } else {
                            if (thermostat.getMode() != Thermostat.Mode.COOL || !thermostat.isOn()) {
                                thermostat.setMode(Thermostat.Mode.COOL);
                                thermostat.setOn(true);
                            }
                        }
                        // Wait 5 minutes before checking temperature again
                        // We should do a dynamic wait depending on the difference between the current & desired temps
                        try {
                            Thread.sleep(updatePeriod);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // The temperature is fine for now, check back after some time
                        try {
                            Thread.sleep(updatePeriod);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }

}
