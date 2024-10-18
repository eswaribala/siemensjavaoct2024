package com.siemens.webstore.webstoreapi.controllers;

import com.siemens.webstore.webstoreapi.configurations.JWTManager;
import com.siemens.webstore.webstoreapi.dtos.JwtRequest;
import com.siemens.webstore.webstoreapi.dtos.JwtResponse;
import com.siemens.webstore.webstoreapi.exceptions.DisabledUserException;
import com.siemens.webstore.webstoreapi.exceptions.InvalidUserCredentialsException;
import com.siemens.webstore.webstoreapi.models.Role;
import com.siemens.webstore.webstoreapi.models.User;
import com.siemens.webstore.webstoreapi.services.UserAuthService;
import com.siemens.webstore.webstoreapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTManager jwtManager;

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
    @PostMapping(value="/v1.0/signin")
    public ResponseEntity<JwtResponse> generateJwtToken(@RequestBody JwtRequest jwtRequest) {

        System.out.println(jwtRequest.getUserName()+""+jwtRequest.getUserPwd());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getUserPwd()));

        } catch (DisabledException e) {
            throw new DisabledUserException("User Inactive");
        } catch (BadCredentialsException e) {
            throw new InvalidUserCredentialsException("Invalid Credentials");
        }
        UserDetails userDetails = userAuthService.loadUserByUserName(jwtRequest.getUserName());
        String username = userDetails.getUsername();
        String userpwd = userDetails.getPassword();
        List<String> roles = userDetails.getAuthorities().stream().map(r -> r.getAuthority())
                .collect(Collectors.toList());


        User user = new User();
        user.setUserName(username);
        user.setPassword(userpwd);
        List<Role> roleList = new ArrayList(roles);
        user.setRoles(roleList);
        String token = jwtManager.generateToken(user);
        return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.OK);
    }


}
