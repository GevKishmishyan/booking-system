package com.epam.bookingsystem.cotroler;

import com.epam.bookingsystem.model.User;
import com.epam.bookingsystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserRepo userRepo;

    @GetMapping("/user")
    public List<User> allUser(){
        return userRepo.findAll();
    }
    @PostMapping("/user/save")
    public void saveUser(){
        User user = new User();
        user.setName("Poxos");
        user.setAge(25);
        userRepo.save(user);
    }
}
