package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity,Integer> {

}
