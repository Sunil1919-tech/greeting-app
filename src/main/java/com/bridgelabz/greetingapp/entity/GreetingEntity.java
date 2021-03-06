package com.bridgelabz.greetingapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class GreetingEntity {

    @Id
    @GeneratedValue
    private  int id;
    private String message;
}
