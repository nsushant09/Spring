package com.example.neupanesushant.RestTutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTutorialApplication.class, args);
    }

}

/**
 * Presentation Layer : Controller
 * This will accept the request
 * <p>
 * Service Layer :
 * The controllers can also make use of service layer
 * The service layer will provide services to controllers
 * Service layer will contain business logic of the application
 *
 * Dao / Repository Layer :
 * If Service layer need any data , Dao/Repository will fetch / put / delete / update data from the database
 *
 *
 * Database :
 * Store data
 *
 * Important Methods : GET, POST, PUT, DELETE
 *
 */
