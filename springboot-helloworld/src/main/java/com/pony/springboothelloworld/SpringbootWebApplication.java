package com.pony.springboothelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource(locations = {"classpath:dog.xml"})
public class SpringbootWebApplication {

    public static void main(String[] args) {
        System.out.println("web application");
       SpringApplication.run(SpringbootWebApplication.class, args);
    }

}
