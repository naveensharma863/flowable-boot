package com.flowable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flowable.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
	Person findByUsername(String username);
	
}
