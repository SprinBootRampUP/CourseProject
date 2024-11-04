package org.example.springboot;
import org.example.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.stereotype.Controller;

@Component
public class Demo {

    @Autowired
    private final TestService testService;

@Autowired
    Demo( TestService testService){
    this.testService=testService;
        System.out.println(testService.getServiceName());
    }






}
