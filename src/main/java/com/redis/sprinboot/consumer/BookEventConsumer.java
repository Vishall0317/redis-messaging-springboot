package com.redis.sprinboot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class BookEventConsumer implements MessageListener {

    Logger logger= LoggerFactory.getLogger(BookEventConsumer.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        logger.info("Consume event: {}", message);
    }
}
