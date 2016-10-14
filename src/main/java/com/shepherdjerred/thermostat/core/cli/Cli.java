package com.shepherdjerred.thermostat.core.cli;

import com.shepherdjerred.thermostat.core.Main;
import org.apache.commons.lang3.StringUtils;

import static java.lang.Boolean.parseBoolean;

public class Cli {

    public void parse(String command, String argument) {

        switch (command) {

            case "help":
                System.out.println("Commands: help, temp, tolerance, period, delay, enabled");
                break;
            case "stop":
                Main.stop();
                break;
            case "status":
                System.out.println("CURRENT STATUS\n");
                System.out.println("Target Temp: " + Main.getController().getTargetTemp());
                System.out.println("Current Temp: " + Main.getController().getThermometer().getTemp());
                System.out.println("Current Humidity: " + Main.getController().getThermometer().getHumidity());
                System.out.println("Mode: " + Main.getController().getThermostat().getMode().toString());
                System.out.println("\n");
                System.out.println("Enabled: " + Main.getController().isEnabled());
                System.out.println("Tolerance: " + Main.getController().getTolerance());
                System.out.println("Update Period: " + Main.getController().getUpdatePeriod());
                System.out.println("Retry Delay: " + Main.getController().getThermometer().getRetryDelay());
                break;
            case "tolerance":
                int tolerance;
                if (argument == null || !StringUtils.isNumeric(argument))
                    tolerance = 2;
                else
                    tolerance = Integer.valueOf(argument);
                Main.getController().setTolerance(tolerance);
                System.out.println("Tolerance set to " + argument);
                break;
            case "period":
                long period;
                if (argument == null || !StringUtils.isNumeric(argument))
                    period = 1000;
                else
                    period = Long.valueOf(argument);
                Main.getController().setUpdatePeriod(period);
                System.out.println("Update period set to " + period);
                break;
            case "delay":
                long delay;
                if (argument == null || !StringUtils.isNumeric(argument))
                    delay = 1000;
                else
                    delay = Long.valueOf(argument);
                Main.getController().setUpdatePeriod(delay);
                System.out.println("Retry delay set to " + delay);
                break;
            case "temp":
                int temp;
                if (argument == null || !StringUtils.isNumeric(argument))
                    temp = 70;
                else
                    temp = Integer.valueOf(argument);
                Main.getController().setTargetTemp(temp);
                System.out.println("Target temperature set to " + temp);
                break;
            case "enabled":
                boolean enabled;
                if (argument == null || parseBoolean(argument))
                    enabled = true;
                else
                    enabled = parseBoolean(argument);
                Main.getController().setEnabled(enabled);
                System.out.println("Enabled set to " + enabled);
                break;
            default:
                parse("help", null);
        }

    }
}
