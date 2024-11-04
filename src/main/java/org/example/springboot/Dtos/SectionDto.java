package org.example.springboot.Dtos;

import lombok.Data;
import java.util.List;

@Data
 public  class SectionDto {
    private Long id;
    private String name;
    private String orderNumber;
    private CourseDto course;
    private List<LectureDto> lectures;
}
