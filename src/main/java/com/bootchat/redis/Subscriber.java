package com.bootchat.redis;

import com.bootchat.websockets.WebSocketSessionManager;
import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.sync.RedisPubSubCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {

    @Autowired
    private WebSocketSessionManager webSocketSessionManager;

    private RedisPubSubCommands<String, String> sync;

    public Subscriber(WebSocketSessionManager webSocketSessionManager){
        this.webSocketSessionManager = webSocketSessionManager;
        RedisClient client = RedisClient.create("redis://localhost:6379");
        StatefulRedisPubSubConnection<String, String> connection = client.connectPubSub();
        var redisListner = new SubscribeMessageHandler(this.webSocketSessionManager);
        connection.addListener(redisListner);
        this.sync = connection.sync();
    }

    public void subscribe(String channel){
        this.sync.subscribe(channel);
    }

    public void  unsubscribe(String channel){
        this.sync.unsubscribe(channel);
    }
}
