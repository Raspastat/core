package com.shepherdjerred.thermostat.core.redis;

import com.shepherdjerred.thermostat.core.Controller;
import redis.clients.jedis.Jedis;

public class JedisManager {

    private static JedisManager jedisManager;
    private Jedis jedis;

    public JedisManager() {
        jedisManager = this;
        jedis = new Jedis("localhost");
        jedis.subscribe(new JedisListener(), "api");
    }

    public void updateStatus() {
        jedis.set("status:target", String.valueOf(Controller.getController().getTargetTemp()));
        jedis.set("status:current", String.valueOf(Controller.getController().getThermometer().getTemp()));
        jedis.set("status:humidity", String.valueOf(Controller.getController().getThermometer().getHumidity()));
        jedis.set("status:mode", String.valueOf(Controller.getController().getThermostat().getMode()));
        jedis.set("status:enabled", String.valueOf(Controller.getController().isEnabled()));
        jedis.set("status:tolerance", String.valueOf(Controller.getController().getTolerance()));
        jedis.set("status:period", String.valueOf(Controller.getController().getUpdatePeriod()));
        jedis.set("status:delay", String.valueOf(Controller.getController().getThermometer().getRetryDelay()));
    }

    public static JedisManager getJedisManager() {
        return jedisManager;
    }

    public Jedis getJedis() {
        return jedis;
    }
}
