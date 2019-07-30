package com.sexton.example.springmediatorexample.request;

import com.sexton.example.springmediatorexample.mediator.Request;

public class MessageRequest implements Request<String> {
    private final String message;

    public MessageRequest(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
