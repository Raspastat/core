package com.shepherdjerred.thermostat.core.redis;

import com.shepherdjerred.thermostat.core.api.Api;
import com.shepherdjerred.thermostat.core.users.User;
import redis.clients.jedis.JedisPubSub;

import java.util.UUID;

public class JedisListener extends JedisPubSub {

    public void onMessage(String channel, String message) {

        UUID requestUuid = UUID.fromString(message);
        User user = User.getUser(User.getUuidFromUsername(JedisManager.getJedisManager().getJedis().get("api:request#" + requestUuid.toString() + ":username")));

        if (!user.authenticate(JedisManager.getJedisManager().getJedis().get("api:request#" + requestUuid.toString() + ":password")))
            return;

        String type = JedisManager.getJedisManager().getJedis().get("api:request#" + requestUuid.toString() + ":type");
        String data = JedisManager.getJedisManager().getJedis().get("api:request#" + requestUuid.toString() + ":data");

        switch (type) {
            case "temp":
                Api.setTemperature(user, Integer.valueOf(data));
                break;
            case "tolerance":
                Api.setTolerance(user, Integer.valueOf(data));
                break;
            case "period":
                Api.setPeriod(user, Integer.valueOf(data));
                break;
            case "enabled":
                Api.setEnabled(user, Boolean.valueOf(data));
                break;
        }

    }

    public void onSubscribe(String channel, int subscribedChannels) {
    }

    public void onUnsubscribe(String channel, int subscribedChannels) {
    }

    public void onPSubscribe(String pattern, int subscribedChannels) {
    }

    public void onPUnsubscribe(String pattern, int subscribedChannels) {
    }

    public void onPMessage(String pattern, String channel, String message) {
    }


}
