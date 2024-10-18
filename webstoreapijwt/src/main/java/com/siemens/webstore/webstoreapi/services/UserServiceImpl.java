package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.Role;
import com.siemens.webstore.webstoreapi.models.User;
import com.siemens.webstore.webstoreapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<Role> getRoles(String userName) {

       User user= this.userRepository
                .findById(userName).orElse(null);
        return user.getRoles();
    }

    @Override
    public User getUserByName(String userName) {
        return this.userRepository
                .findById(userName).orElse(null);
    }
}
