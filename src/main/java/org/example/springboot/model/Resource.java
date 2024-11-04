package org.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Resource extends BaseEntity {


    private String name;
    private Long size;
    private String url;

    @OneToOne(mappedBy = "resource" )
    @JsonBackReference
    private Lecture lecture;


}
