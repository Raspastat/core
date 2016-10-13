package com.shepherdjerred.thermostat.core;

import com.shepherdjerred.thermostat.core.pi.GpioWrapper;
import com.shepherdjerred.thermostat.core.scheduling.Scheduler;
import com.shepherdjerred.thermostat.core.thermometer.DHT11;
import com.shepherdjerred.thermostat.core.theromostat.ConeThermostat;

public class Main {

    public static void main(String[] args) {

        System.out.println("Program started!");
        new GpioWrapper();
        new Controller(new ConeThermostat(), new DHT11(), new Scheduler(74));

        /*
        Updating the temperature
          We'll be updating from two external sources
           - Apps
           - Web Interface
          So we need to expose something. The easiest way would be to open an HTTP server and accept JSON. The apps/web interface would
          Then just need to send JSON requests.
         */

    }

}
