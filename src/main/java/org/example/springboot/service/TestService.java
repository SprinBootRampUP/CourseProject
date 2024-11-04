package org.example.springboot.service;


import lombok.Getter;
import org.example.springboot.model.Author;
import org.example.springboot.model.Course;
import org.example.springboot.repository.AuthorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
//import org.example.springboot.repository.CourseRepository;

import java.util.Arrays;
import java.util.List;

@Service
@Profile("test")
@Getter
public class TestService {

    @Value("${service.name:default value}")
    private String serviceName;

    TestService(){
        System.out.println( "from test profile");
    }

}


@Service
@Profile("dev")
 class DevService {

     DevService(){
        System.out.println( "from dev profile");
    }

}
