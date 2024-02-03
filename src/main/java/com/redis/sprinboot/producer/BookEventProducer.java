package com.redis.sprinboot.producer;

import com.redis.sprinboot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookEventProducer {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    ChannelTopic channelTopic;

    @PostMapping("/publish")
    public String saveBook(@RequestBody Book book) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), book.toString());
        return "event published successfully !!";
    }
}
