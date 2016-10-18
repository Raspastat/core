package com.shepherdjerred.thermostat.core.users;

import java.util.UUID;

public class User {

    private String username;
    private String password;
    private UUID uuid;

    public User(String username, String password, UUID uuid) {
        this.username = username;
        this.password = password;
        this.uuid = uuid;
    }
}
