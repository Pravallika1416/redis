package com.example.redis_demo.service;

import com.example.redis_demo.model.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    private static final String SESSION_KEY_PREFIX = "session:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveUserSession(String sessionId, UserSession session) {
        String key = SESSION_KEY_PREFIX + sessionId;
        redisTemplate.opsForValue().set(key, session, 1, TimeUnit.MINUTES);  // Set session expiry to 30 min
    }

    public UserSession getUserSession(String sessionId) {
        String key = SESSION_KEY_PREFIX + sessionId;
        return (UserSession) redisTemplate.opsForValue().get(key);
    }

    public void deleteUserSession(String sessionId) {
        String key = SESSION_KEY_PREFIX + sessionId;
        redisTemplate.delete(key);
    }
}

