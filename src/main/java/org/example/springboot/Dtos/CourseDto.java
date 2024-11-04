package org.example.springboot.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.springboot.Enums.CourseLevel;

import java.util.List;

@Data
public class CourseDto {

   // private Long id;
    private String courseTitle;
    private String description;
 private String price;

 //  @JsonIgnore
    private CourseLevel courseLevel;
    private AuthorDto author;
    private List<SectionDto> sections;


}
