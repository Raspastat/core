package com.shepherdjerred.thermostat.core.api;

import com.google.gson.JsonObject;
import com.shepherdjerred.thermostat.core.users.User;

public class Request {

    private User user;
    private JsonObject jsonObject;

    public Request(User user, JsonObject jsonObject) {
        this.user = user;
        this.jsonObject = jsonObject;
    }
}