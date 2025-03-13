package com.example.redis_demo;



import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    private final RedisTemplate<String, Object> redisTemplate;

    public UserService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private static final String USER_KEY_PREFIX = "USER:";

    public void saveUser(User user) {
        redisTemplate.opsForValue().set(USER_KEY_PREFIX + user.getId(), user.getName(), 10, TimeUnit.MINUTES);
    }

    public String getUser(String userId) {
        return (String) redisTemplate.opsForValue().get(USER_KEY_PREFIX + userId);
    }

    public void deleteUser(String userId) {
        redisTemplate.delete(USER_KEY_PREFIX + userId);
    }
}

