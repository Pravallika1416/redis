package com.example.redis_demo.service;



import com.example.redis_demo.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private static final String USER_HASH_KEY = "USER";

    private final HashOperations<String, String, User> hashOperations;

    public UserService(RedisTemplate<String, User> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    // Save user to Redis Hash
    public void saveUser(User user) {
        hashOperations.put(USER_HASH_KEY, user.getId(), user);
    }

    // Get user by ID
    public User getUser(String userId) {
        return hashOperations.get(USER_HASH_KEY, userId);
    }

    // Get all users
    public Map<String, User> getAllUsers() {
        return hashOperations.entries(USER_HASH_KEY);
    }

    // Delete user by ID
    public void deleteUser(String userId) {
        hashOperations.delete(USER_HASH_KEY, userId);
    }
}

