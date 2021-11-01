package com.pony.springboothelloworld.service;

import org.springframework.stereotype.Service;

@Service
public class PrintService {
    public void printHello() {
        System.out.println("hello,worlds");
    }
}
