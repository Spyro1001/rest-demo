package com.example.rest.config;

import com.example.rest.model.Message;
import com.example.rest.repository.HelloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bootstrap implements CommandLineRunner {

    private final HelloRepository repository;

    public Bootstrap(HelloRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        // clear old data
        repository.deleteAll();

        repository.save(new Message("Hello World!"));
        repository.save(new Message("Hello There!"));
        repository.save(new Message("Greetings!"));
        repository.save(new Message("Howdy!"));
        repository.save(new Message("Hey!"));
    }
}
