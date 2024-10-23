package io.github.ramajd.SpringSecurityDemo.controller;

import io.github.ramajd.SpringSecurityDemo.model.Users;
import io.github.ramajd.SpringSecurityDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/users")
    public List<Users> list() {
        return service.listUsers();
    }


    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }
}
