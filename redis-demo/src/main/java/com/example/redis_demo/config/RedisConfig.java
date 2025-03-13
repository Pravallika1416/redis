package com.example.redis_demo.config;

import com.example.redis_demo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, User> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

//        // Set key serializer (store keys as plain text)
//        template.setKeySerializer(new StringRedisSerializer());
//
//        // Set value serializer (store objects as JSON)
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // Use StringRedisSerializer for keys
        template.setKeySerializer(new StringRedisSerializer());

        // Use Jackson for JSON serialization of values
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));

        return template;
    }
}

