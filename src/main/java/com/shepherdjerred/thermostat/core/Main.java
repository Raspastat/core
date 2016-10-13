package com.shepherdjerred.thermostat.core;

import com.shepherdjerred.thermostat.core.pi.GpioWrapper;
import com.shepherdjerred.thermostat.core.scheduling.Scheduler;
import com.shepherdjerred.thermostat.core.thermometer.Thermometer;
import com.shepherdjerred.thermostat.core.theromostat.DormThermostat;

public class Main {

    static void main() {

        new GpioWrapper();
        new Controller(new DormThermostat(), new Thermometer(), new Scheduler(70));

        System.out.println("Program started!");

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
