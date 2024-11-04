package org.example.springboot.service;

import org.example.springboot.model.CustomUserDetails;
import org.example.springboot.model.User;
import org.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.User;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByuserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        System.out.printf("From here$$$$$$$$$$$$$$$$$$$$$$$$$$$");
       // return new CustomUserDetails(user);
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword()
//                ,Collections.emptyList());
        return new CustomUserDetails(user);

    }

    public void d(){
        UserDetails ss=  loadUserByUsername("de");
        //ss.g
    }

}
