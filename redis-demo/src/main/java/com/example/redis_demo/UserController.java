package com.example.redis_demo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser/cache")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User saved!";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "User deleted!";
    }
}

