package com.pony.springboothelloworld;

import com.pony.springboothelloworld.model.Person;
import com.pony.springboothelloworld.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import javax.swing.*;

@SpringBootApplication
public class SpringbootAppApplication implements CommandLineRunner {
    @Autowired
    private PrintService printService;

    @Autowired
    Person person;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(person.toString());
        printService.printHello();
        System.out.println("hello");
    }
}
