package com.shepherdjerred.thermostat.core;

import org.apache.commons.lang3.StringUtils;

import static java.lang.Boolean.parseBoolean;

public class Cli {

    public void setup() {
        new Thread() {
            @Override
            public void run() {
                while (true) {

                    String[] input = System.console().readLine().split(" ");

                    if (input.length < 0)
                        return;

                    if (input.length > 2) {
                        System.out.println("Too many arguments");
                        return;
                    }

                    String cmd = input[0];
                    String arg = null;

                    if (input.length > 1) {
                        arg = input[1];
                    }

                    new Cli().parse(cmd, arg);

                }
            }
        }.start();
    }

    public void parse(String command, String argument) {

        switch (command) {

            case "help":
                System.out.println("Commands: help, temp, tolerance, period, delay, enabled");
                break;
            case "stop":
                Main.stop();
                break;
            case "status":
                System.out.println("\n\nCURRENT STATUS\n");
                System.out.println("Target Temp: " + Controller.getController().getTargetTemp() + "F");
                System.out.println("Current Temp: " + Controller.getController().getThermometer().getTemp() + "F");
                System.out.println("Current Humidity: " + Controller.getController().getThermometer().getHumidity() + "%");
                System.out.println("Mode: " + Controller.getController().getThermostat().getMode().toString());
                System.out.println("");
                System.out.println("Enabled: " + Controller.getController().isEnabled());
                System.out.println("Tolerance: " + Controller.getController().getTolerance() + "F");
                System.out.println("Update Period: " + Controller.getController().getUpdatePeriod() + "ms");
                System.out.println("Retry Delay: " + Controller.getController().getThermometer().getRetryDelay() + "ms");
                break;
            case "tolerance":
                int tolerance;
                if (argument == null || !StringUtils.isNumeric(argument))
                    tolerance = 2;
                else
                    tolerance = Integer.valueOf(argument);
                Controller.getController().setTolerance(tolerance);
                System.out.println("Tolerance set to " + argument + "F");
                break;
            case "period":
                long period;
                if (argument == null || !StringUtils.isNumeric(argument))
                    period = 1000;
                else
                    period = Long.valueOf(argument);
                Controller.getController().setUpdatePeriod(period);
                System.out.println("Update period set to " + period + "ms");
                break;
            case "delay":
                long delay;
                if (argument == null || !StringUtils.isNumeric(argument))
                    delay = 1000;
                else
                    delay = Long.valueOf(argument);
                Controller.getController().setUpdatePeriod(delay);
                System.out.println("Retry delay set to " + delay + "ms");
                break;
            case "temp":
                int temp;
                if (argument == null || !StringUtils.isNumeric(argument))
                    temp = 70;
                else
                    temp = Integer.valueOf(argument);
                Controller.getController().setTargetTemp(temp);
                System.out.println("Target temperature set to " + temp + "F");
                break;
            case "enabled":
                boolean enabled;
                if (argument == null || parseBoolean(argument))
                    enabled = true;
                else
                    enabled = parseBoolean(argument);
                Controller.getController().setEnabled(enabled);
                System.out.println("Enabled set to " + enabled);
                break;
            default:
                parse("help", null);
        }

    }
}
