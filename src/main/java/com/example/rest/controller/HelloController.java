package com.example.rest.controller;

import com.example.rest.model.Message;
import com.example.rest.model.nexus.NexusAssetResponse;
import com.example.rest.service.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    HelloService service;

    public HelloController(HelloService service) {
        this.service = service;
    }

    // Create
    @PostMapping(value = "/addMessage", produces = "application/json")
    public Message setMessage(@RequestBody Message message) {
        return this.service.saveMessage(message);
    }

    // Read
    @GetMapping(value = "/getAllMessages")
    @ResponseStatus(HttpStatus.OK)
    public List<Message> getAllMessages() {
        return this.service.getAllMessages();
    }

    @GetMapping(value = "/getMessageById/{id}", produces = "application/json")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        Message result = this.service.getMessageById(id);
        HttpStatus status = HttpStatus.OK;
        if(result == null) {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity(result, status);
    }

    @GetMapping(value = "/getAllMessagesByContent", produces = "application/json")
    public List<Message> getAllMessagesByContent(@RequestParam(value = "match") String matching) {
        return this.service.getAllMessagesByContent(matching);
    }

    // Update
    @PutMapping(value = "updateMessage/{id}", produces = "application/json")
    public ResponseEntity<String> updateMessage(@PathVariable Long id, @RequestBody Message message) {

        // per HTTP spec RFC 2616, Section 9.6
        Message result = this.service.updateMessage(id, message);
        HttpStatus status = HttpStatus.NO_CONTENT;
        String responseMessage = "";
        if (result == null) {
            responseMessage = "Invalid id!";
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseMessage, status);
    }

    // Delete
    @DeleteMapping(value = "deleteMessage/{id}", produces = "application/json")
    public ResponseEntity<String> deleteMessage(@PathVariable Long id) {

        Boolean success = this.service.deleteMessage(id);
        HttpStatus status;
        String message = "";

        if(success) {
            status = HttpStatus.NO_CONTENT;
        } else {
            status = HttpStatus.NOT_FOUND;
            message = "Resource not found.";
        }

        return new ResponseEntity(message, status);
    }



}
