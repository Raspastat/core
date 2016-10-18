package com.shepherdjerred.thermostat.core.api;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Api {

    private int port;
    private boolean enabled;
    private ServerSocket serverSocket;

    public Api(int port) {
        try {
            serverSocket = new ServerSocket(port);
            enabled = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        while (enabled) {
            try {
                Socket clientSocket = serverSocket.accept();
                new ApiThread(clientSocket).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isEnabled() {
        return enabled;
    }
}