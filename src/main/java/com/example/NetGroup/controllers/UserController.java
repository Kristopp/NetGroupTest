package com.example.NetGroup.controllers;



import com.example.NetGroup.model.User;

import com.example.NetGroup.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

//ALL User related EndPoints
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    //inject it into constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //we want to get All users
    //ResponseEntity is a generic so we need to pass what kind of data we are passing in this case its a list
    //List is generic to so we have to specify a list of what
    // will response HTTP body and list of users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> usersList = userService.findAllUsers();
        //return
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    //Find user by id
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws UserPrincipalNotFoundException {
        User user = userService.findUsersById(id);
        //return
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    //Add user
    //We use post request here because we are making change in database

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        System.out.println("hello");
        User newUser = userService.createNewUser(user);
        //return
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    //Delete user
    @PutMapping("/update")
    public ResponseEntity<User> upDateUser(User user) {
        User userUpdated = userService.updateUser(user);
        //return
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    //Delete method wont return anything
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
