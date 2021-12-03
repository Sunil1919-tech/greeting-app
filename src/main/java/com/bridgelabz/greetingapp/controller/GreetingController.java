package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @GetMapping(value = "/greet")
    public String getMessage() {
        return "Hello from BridgeLabz";
    }

    @GetMapping(value = "/message")
    public String getGreeting(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return "Hello" + firstName + " " + lastName;
    }

    @PostMapping(value = "/getGreet")
    public UserDTO userDetails(
            @RequestBody UserDTO userDTO
    ) {
        return userDTO;
    }
}
