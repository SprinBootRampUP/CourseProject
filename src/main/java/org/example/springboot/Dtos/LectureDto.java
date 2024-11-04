package org.example.springboot.Dtos;

import lombok.Data;

@Data
public class LectureDto {
    private Long id;
    private String name;
    private SectionDto section;
    private ResourceDto resource;

}
