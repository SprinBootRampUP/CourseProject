package org.example.springboot.service;

import org.example.springboot.model.User;
import org.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;
   // private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    LoginService( UserRepository userRepository){
        this.userRepository=userRepository;
        //this.passwordEncoder=passwordEncoder;
    }

        public boolean register(User user) {
        if (userRepository.findByuserName(user.getUserName()).isPresent()) {
            return false;
        }
           // user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setPassword(user.getPassword());

            userRepository.save(user);
        return true;
    }

//    public boolean login(User user) {
//        if (userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).isPresent()) {
//            return false;
//        }
//        userRepository.save(user);
//        return true;
//    }

}
