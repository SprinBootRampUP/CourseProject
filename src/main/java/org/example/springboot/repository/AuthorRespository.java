package org.example.springboot.repository;


import org.example.springboot.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRespository extends JpaRepository<Author, Integer> {


    List<Author> findAuthorByFirstName(String name);

    Author findById(Long id);

    //List<Author> findCoursesById(Long id);

    List<Author> findByCoursesId(Long id);

}
