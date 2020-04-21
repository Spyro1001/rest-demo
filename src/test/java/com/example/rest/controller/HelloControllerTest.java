package com.example.rest.controller;

import com.example.rest.model.Message;
import com.example.rest.repository.HelloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HelloControllerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void setMessage() {
    }

    @Test
    void getAllMessages() {
    }

    @Test
    void getMessageById() {
    }

    @Test
    void getAllMessagesByContent() {
    }

    @Test
    void updateMessage() {
    }

    @Test
    void deleteMessage() {
    }
}
