package com.sexton.example.springmediatorexample.controller;

import com.sexton.example.springmediatorexample.mediator.Mediator;
import com.sexton.example.springmediatorexample.request.DisplayConsoleMessageRequest;
import com.sexton.example.springmediatorexample.request.MessageRequest;
import com.sexton.example.springmediatorexample.request.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final Mediator mediator;

    @Autowired
    public TestController(final Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("test")
    public ResponseEntity<String> test() {
        final String response = mediator.send(new TestRequest());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("greet")
    public ResponseEntity<String> message(final @RequestParam("message") String message) {
        mediator.send(new DisplayConsoleMessageRequest(message));
        final String response = mediator.send(new MessageRequest(message));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
