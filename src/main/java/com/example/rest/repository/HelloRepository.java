package com.example.rest.repository;

import com.example.rest.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HelloRepository extends CrudRepository<Message, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    public List<Message> findByMessageContaining(String matching);
}
