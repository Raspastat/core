package com.shepherdjerred.thermostat.core.redis;

import com.shepherdjerred.thermostat.core.Main;
import redis.clients.jedis.Jedis;

public class JedisManager {

    private static JedisManager jedisManager;
    private Jedis jedis = new Jedis("localhost");

    public JedisManager() {
        jedisManager = this;
        new Thread() {
            @Override
            public void run() {
                jedis.subscribe(new JedisListener(), "api");
            }
        }.start();
    }

    public static JedisManager getJedisManager() {
        return jedisManager;
    }

    public void updateStatus() {
        if (jedis == null)
            System.out.println("Jedis issue");
        jedis.set("status:target", "1");
        jedis.set("status:current", String.valueOf(Main.getController().getThermometer().getTemp()));
        jedis.set("status:humidity", String.valueOf(Main.getController().getThermometer().getHumidity()));
        jedis.set("status:mode", String.valueOf(Main.getController().getThermostat().getMode()));
        jedis.set("status:enabled", String.valueOf(Main.getController().isEnabled()));
        jedis.set("status:tolerance", String.valueOf(Main.getController().getTolerance()));
        jedis.set("status:period", String.valueOf(Main.getController().getUpdatePeriod()));
        jedis.set("status:delay", String.valueOf(Main.getController().getThermometer().getRetryDelay()));
    }

    public Jedis getJedis() {
        return jedis;
    }
}