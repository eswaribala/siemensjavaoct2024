package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.exceptions.UserNotFoundException;
import com.siemens.webstore.webstoreapi.models.Role;
import com.siemens.webstore.webstoreapi.models.User;
import com.siemens.webstore.webstoreapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User addUser(User user) {
        System.out.println(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<Role> getRoles(String userName) {

       User user= this.userRepository
                .findById(userName).orElseThrow(()->
                       new UserNotFoundException("User not Available"));
       return user.getRoles();

    }

    @Override
    public User getUserByName(String userName) {
        return this.userRepository
                .findById(userName).orElse(null);
    }
}
