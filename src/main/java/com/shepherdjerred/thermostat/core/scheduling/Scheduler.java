package com.shepherdjerred.thermostat.core.scheduling;

import java.util.LinkedList;

public class Scheduler {

    private int defaultTemp;
    private LinkedList<Entry> entries = new LinkedList<>();
    private long nextEntry;

    public Scheduler(int defaultTemp) {
        this.defaultTemp = defaultTemp;
        loadEntries();
        System.out.println("Default temp is " + defaultTemp);
    }

    public int getDefaultTemp() {
        return defaultTemp;
    }

    public LinkedList<Entry> getEntries() {
        return entries;
    }

    public long getNextEntry() {
        return nextEntry;
    }

    public void loadEntries() {

    }
}
