package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.entity.GreetingEntity;
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

    public GreetingEntity saveMessage(GreetingDTO greetingDto) {
        GreetingEntity greeting = new GreetingEntity();
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

    public String findGreetingByID(int id) {
        Optional<GreetingEntity> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            return "The Greeting with id is present:" + id;
        }
        return "not found id:" + id;
    }

    public String editGreeting(int id, GreetingDTO greetingDTO) {
        GreetingEntity updateMessage = greetingRepository.findById(id).get();
        updateMessage.setMessage(greetingDTO.getMessage());
        greetingRepository.save(updateMessage);
        return "Greeting edited successfully " + id;
    }
}
