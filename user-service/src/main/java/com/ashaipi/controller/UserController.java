package com.ashaipi.controller;

import com.ashaipi.model.User;
import com.ashaipi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userServiceImpl.allUsers();
            return ResponseEntity.ok(users); // Return HTTP 200 with the list of users
        } catch (Exception ex) {
            // Handle errors and return a meaningful response
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching users", ex);
        }
    }

}
