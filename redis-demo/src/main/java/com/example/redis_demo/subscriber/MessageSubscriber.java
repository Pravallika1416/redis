package com.example.redis_demo.subscriber;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageSubscriber {
    private static final Logger logger = LoggerFactory.getLogger(MessageSubscriber.class);

    public void onMessage(String message, String channel) {
        logger.info("Received message: '{}' from channel: '{}'", message, channel);
    }
}

