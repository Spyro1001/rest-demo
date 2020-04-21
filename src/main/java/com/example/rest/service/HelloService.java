package com.example.rest.service;

import com.example.rest.model.Message;
import com.example.rest.repository.HelloRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class HelloService {

    HelloRepository repository;

    public HelloService(HelloRepository repository) {
        this.repository = repository;
    }

    public Message saveMessage(Message message) {
        return this.repository.save(message);
    }

    public List<Message> getAllMessages() {
        return (List<Message>) this.repository.findAll();
    }

    public Message getMessageById(Long id) {
        Message result = null;
        try {
            result = this.repository.findById(id).get();
        } catch (NoSuchElementException e) {
            // log.debug
        }
        return result;
    }

    public List<Message> getAllMessagesByContent(String matching) {

        return this.repository.findByMessageContaining(matching);

    }

    public Message updateMessage(Long id, Message message) {
        Message result = null;
        message.setId(id);
        if(messageExists(id)) {
            result = this.repository.save(message);
        }
        return result;
    }

    // Test for message existence
    private boolean messageExists(Long id) {
        boolean exists = true;
        Message result = null;
        try {
            result = repository.findById(id).get();
        } catch (NoSuchElementException e) {
            exists = false;
        }
        return exists;
    }

    public Boolean deleteMessage(Long id) {
        boolean success = true;
        try {
            this.repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            success = false;
        }
        return success;
    }
}
