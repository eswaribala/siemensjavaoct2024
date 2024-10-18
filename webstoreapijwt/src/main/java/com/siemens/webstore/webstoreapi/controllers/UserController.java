package com.siemens.webstore.webstoreapi.controllers;

import com.siemens.webstore.webstoreapi.models.User;
import com.siemens.webstore.webstoreapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/v1.0/signup")
    public ResponseEntity<String> addUser(@RequestBody User user){

        //Check user existence
        User userObject=this.userService.getUserByName(user.getUserName());
        if(userObject!=null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Already Exists");
        else {
            User userInstance = this.userService.addUser(user);
            if (userInstance != null)
                return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
            else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not able to Register");
        }

    }


}
