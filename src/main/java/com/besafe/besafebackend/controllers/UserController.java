package com.besafe.besafebackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/health")
    public String getHealth(){
        return "BeSafe is running";
    }

    @GetMapping("/user/exists/{userId}")
    public String checkIfUserExists(@PathVariable String userId){
        return userId+" exists";
    }
}
