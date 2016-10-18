package com.shepherdjerred.thermostat.core.api;

import com.shepherdjerred.thermostat.core.Controller;
import com.shepherdjerred.thermostat.core.users.User;

public class Api {

    // TODO Log the users action
    public static void setTemperature(User user, int temp) {
        Controller.getController().setTargetTemp(temp);
    }

    public static void setTolerance(User user, int tolerance) {
        Controller.getController().setTolerance(tolerance);
    }

    public static void setPeriod(User user, int period) {
        Controller.getController().setUpdatePeriod(period);
    }

    public static void setEnabled(User user, boolean enabled) {
        Controller.getController().setEnabled(enabled);
    }

}