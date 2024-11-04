package org.example.springboot.Dtos;


import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private List<CourseDto> courses;
}

