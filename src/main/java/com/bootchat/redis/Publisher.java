package com.bootchat.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    RedisClient client;
    StatefulRedisConnection<String, String> connection;

    private static final Logger logger = LoggerFactory.getLogger(Publisher.class);

    public Publisher(){
        this.client = RedisClient.create("redis://localhost:6379");
        connection = this.client.connect();
    }

    public void publish(String channel, String message){
        logger.info("going to publish the message to channel {} and message = {}", channel, message);
        connection.sync().publish(channel,message);
    }
}
