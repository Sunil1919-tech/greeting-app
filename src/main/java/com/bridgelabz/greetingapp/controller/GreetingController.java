package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.entity.GreetingEntity;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    @GetMapping(value = "/greet")
    public String getGreeting() {
        return "Hello from BridgeLabz";
    }

    @GetMapping(value ="/{name}")
    public String getPath(
            @PathVariable String name
    ) {
        return "Hello " + name + " from Hyderabad";
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

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/message1")
    public String getMessage() {
        return greetingService.getMessage();
    }

    @PostMapping("/greetingMessage")
    public GreetingEntity saveGreeting(
            @RequestBody GreetingDTO greetingDTO
    ) {
        return greetingService.saveMessage(greetingDTO);
    }
    @GetMapping(value = "/get-all-greetings")
    public List<GreetingDTO> getAllGreeting(){
        return greetingService.getAllMessages();
    }

    @GetMapping("/get-message-by-id/{id}")
    public String findGreetByID(
            @PathVariable int id
    ) {
        return greetingService.findGreetingByID(id);
    }

    @PutMapping("/update-message/{id}")
    public String editGreet(
            @PathVariable(value = "id") int id,
            @RequestBody GreetingDTO greetingDTO
    ){
        return greetingService.editGreeting(id,greetingDTO);
    }

    @DeleteMapping(value = "/delete-greet/{id}")
    public String deleteGreeting(
            @PathVariable(value = "id") int id
    ){
        return greetingService.deleteGreeting(id);
    }
}
