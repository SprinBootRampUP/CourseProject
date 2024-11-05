package org.example.springboot.controller;

import jakarta.validation.Valid;
import org.example.springboot.Dtos.ApiResponse;
import org.example.springboot.Dtos.CourseDto;
import org.example.springboot.Dtos.LectureDto;
import org.example.springboot.Dtos.SectionDto;
import org.example.springboot.model.Course;
import org.example.springboot.model.Lecture;
import org.example.springboot.model.Resource;
import org.example.springboot.model.Section;
import org.example.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/courses")
public class CourseController {


    private final CourseService courseService;

    @Autowired
    CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public  String getCourses(Model model){
        List<CourseDto> courses = courseService.getCourses();
        model.addAttribute( "courses", courses);
        return "courses" ;
    }



    @GetMapping("/create")
    @PreAuthorize("hasRole('AUTHOR')")
    public String createCourse(Model model) {
        model.addAttribute("course", new CourseDto());
        return "create_course";
    }


    @PostMapping
    public String createCourse(@ModelAttribute("course") CourseDto courseDTO) {
        courseService.addCourseWithSections(courseDTO);
        System.out.println(courseDTO);
        return "redirect:/courses";
    }



}
