package com.shepherdjerred.thermostat.core.pi;

import com.pi4j.io.gpio.*;

public class GpioWrapper {

    private final static GpioController gpio = GpioFactory.getInstance();
    private final static GpioPinDigitalOutput cooling = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Cooling", PinState.LOW);
    private final static GpioPinDigitalOutput heating = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Heating", PinState.LOW);

    public GpioWrapper() {
        heating.setShutdownOptions(true, PinState.LOW);
        cooling.setShutdownOptions(true, PinState.LOW);
        System.out.println("Shutdown options set");
    }

    public static GpioController getGpio() {
        return gpio;
    }

    public static GpioPinDigitalOutput getCooling() {
        return cooling;
    }

    public static GpioPinDigitalOutput getHeating() {
        return heating;
    }
}
