package ru.oktemsec.catalogalbankshell.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String helloTo(String username) {
        return "Hello, " + username;
    }
}