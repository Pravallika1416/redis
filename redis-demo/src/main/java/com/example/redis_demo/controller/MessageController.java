package com.example.redis_demo.controller;




import com.example.redis_demo.publisher.MessagePublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publish")
public class MessageController {
    private final MessagePublisher messagePublisher;

    public MessageController(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @PostMapping
    public String publishMessage(@RequestParam String message) {
        messagePublisher.publish(message);
        return "Message sent: " + message;
    }
}
