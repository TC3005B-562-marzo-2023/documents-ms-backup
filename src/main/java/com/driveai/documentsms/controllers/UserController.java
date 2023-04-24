package com.driveai.documentsms.controllers;

import com.driveai.documentsms.models.User;
import com.driveai.documentsms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam("id") int id){
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
    }
}