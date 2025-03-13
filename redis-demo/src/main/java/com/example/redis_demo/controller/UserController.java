package com.example.redis_demo.controller;


import com.example.redis_demo.model.UserSession;
import com.example.redis_demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/session")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public String createSession(HttpSession session, @RequestBody UserSession userSession) {
        String sessionId = session.getId();
        userService.saveUserSession(sessionId, userSession);
        return "Session created with ID: " + sessionId;
    }

    @GetMapping("/get")
    public UserSession getSession(HttpSession session) {
        return userService.getUserSession(session.getId());
    }

    @DeleteMapping("/logout")
    public String logout(HttpSession session) {
        userService.deleteUserSession(session.getId());
        return "User logged out, session removed.";
    }
}
