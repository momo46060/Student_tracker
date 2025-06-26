package com.mycollapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

     @GetMapping("/")
     public String hello() {

         return "Hello, World!  Welcome to MyCollApp!   ";
     }
}
