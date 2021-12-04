package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GreetingService {

    @Autowired
    GreetingRepository greetingRepository;

    public String getMessage() {
        return "Hello World...!";
    }

    public Greeting saveMessage(GreetingDTO greetingDto) {
        Greeting greeting = new Greeting();
        greeting.setMessage(greetingDto.getMessage());
        return greetingRepository.save(greeting);
    }

    public List<GreetingDTO> getAllMessages() {
        return greetingRepository
                .findAll()
                .stream()
                .map(greeting -> {
                    GreetingDTO greetingDTO = new GreetingDTO();
                    greetingDTO.setMessage(greeting.getMessage());
                    return greetingDTO;
                })
                .collect(Collectors.toList());
    }
}
