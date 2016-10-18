package com.shepherdjerred.thermostat.core.redis;

import redis.clients.jedis.Jedis;

public class JedisManager {

    JedisManager() {
        Jedis jedis = new Jedis("localhost");
        jedis.subscribe(new JsonListener(), "foo");
    }

}
