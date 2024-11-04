package org.example.springboot.Dtos;

import lombok.Data;

@Data
public class ResourceDto {
    private Long id;
    private String name;
    private Long size;
    private String url;
    private LectureDto lecture;
}
