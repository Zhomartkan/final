package com.example.HospitalSystem.controller;

import com.example.HospitalSystem.Services.UserService;
import com.example.HospitalSystem.objects.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id).get();
    }

    @PostMapping("")
    public void addUser(@RequestBody Users users) {
        userService.addUser(users);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody Users users) {
        userService.updateUser(id, users);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }


}
