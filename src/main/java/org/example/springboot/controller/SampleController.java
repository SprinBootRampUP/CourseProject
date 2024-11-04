package org.example.springboot.controller;

import org.example.springboot.Dtos.ApiResponse;
import org.example.springboot.model.Course;
import org.example.springboot.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criteria")
public class SampleController {

private final SampleService sampleService;

    @Autowired
    SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }


    @GetMapping
    public ResponseEntity<ApiResponse> searchCourses(@RequestParam(defaultValue = " ") String search ){

        try{
            List<Course> courses=sampleService.getByCriteriaQuery(search);

            return  ResponseEntity.ok( new ApiResponse("Courses Fetched Successfully" , courses));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }








    }




}
