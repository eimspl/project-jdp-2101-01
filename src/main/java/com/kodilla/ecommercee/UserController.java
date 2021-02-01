package com.kodilla.ecommercee;


import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController
@RequestMapping("/v1/User")
@CrossOrigin("*")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "createNewUser")
    public UserDto createUser() {
        return new UserDto("Adam","Kowalski","adam.kowalski@wp.pl");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "banUser")
    public UserDto banUser(@RequestParam Long userId) {
        return new UserDto("bannedUserName","bannedUserSurname","bannedUserMail");
    }

    @RequestMapping(method = RequestMethod.GET, value = "getKey")
    public Integer getKey(@RequestParam Long userId) {
        Random random = new Random();
        int a = random.nextInt(101);
        return a+999;
    }

}
