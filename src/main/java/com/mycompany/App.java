package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by bhavsarer on 7/15/15.
 */
    @EnableAutoConfiguration
    @ComponentScan("com.mycompany")
    public class App {

        public static void main(String[] args) {
            SpringApplication.run(App.class,args);
        }

    }
