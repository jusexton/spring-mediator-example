package com.sexton.example.springmediatorexample.handler;

import com.sexton.example.springmediatorexample.mediator.RequestHandler;
import com.sexton.example.springmediatorexample.request.TestRequest;
import org.springframework.stereotype.Component;

@Component
public class TestRequestHandler implements RequestHandler<TestRequest, String> {
    @Override
    public String handle(TestRequest request) {
        // Just returns a hard coded value.
        return "Test Request";
    }
}
