package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.Role;
import com.siemens.webstore.webstoreapi.models.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    List<User> getAllUsers();

    List<Role> getRoles(String userName);
    User getUserByName(String userName);

}
