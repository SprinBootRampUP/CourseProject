package org.example.springboot.service;

import org.example.springboot.model.Author;
import org.example.springboot.repository.AuthorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRespository authorRespository;

    public List<Author> findAuthorsByCourseID(Long courseId){

        return authorRespository.findByCoursesId(courseId);
    }

    public List<Author> findAuthorByName(String name){

        return authorRespository.findAuthorByFirstName(name);
    }

}
