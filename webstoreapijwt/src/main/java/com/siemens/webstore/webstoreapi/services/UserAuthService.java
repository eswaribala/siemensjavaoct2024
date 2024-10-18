package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.Role;
import com.siemens.webstore.webstoreapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAuthService {
    @Autowired
    private UserService userService;

    public UserDetails loadUserByUserName(String userName){
    User user=this.userService.getUserByName(userName);
    if(user==null){

         throw new UsernameNotFoundException("User Not Existing");
    }else{

        List<Role> roles=userService.getRoles(userName);
        List<GrantedAuthority> grantedAuthorities = roles.stream().map(r -> {
            return new SimpleGrantedAuthority(r.getRoleName());
        }).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                grantedAuthorities);

    }

    }

}
