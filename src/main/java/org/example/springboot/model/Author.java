package org.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL )
    @JsonManagedReference
 private List<Course> courses;

}