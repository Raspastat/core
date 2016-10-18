package com.shepherdjerred.thermostat.core;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Logger {

    private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("log");
    private FileHandler fh;

    public void setupLogging() {
        try {
            System.out.println("Saving log to output.log");
            fh = new FileHandler("output.log");
            logger.setUseParentHandlers(false);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public java.util.logging.Logger getLogger() {
        return logger;
    }

}
