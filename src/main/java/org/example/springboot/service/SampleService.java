package org.example.springboot.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.example.springboot.model.Course;
import org.example.springboot.model.Lecture;
import org.example.springboot.model.Resource;
import org.example.springboot.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleService {

    @Autowired
    private EntityManager entityManager;

        public List<Course> getByCriteriaQuery(String search){

            CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
            CriteriaQuery<Course> criteriaQuery= criteriaBuilder.createQuery(Course.class);


            Root<Course> courseRoot= criteriaQuery.from(Course.class);

            Join<Course, Section> sectionJoin = courseRoot.join("sections", JoinType.LEFT);
            Join<Section, Lecture> lectureJoin = sectionJoin.join("lectures", JoinType.LEFT);
            Join<Lecture, Resource> resourceJoin = lectureJoin.join("resource", JoinType.LEFT);



            List<Predicate> predicates = new ArrayList<>();


            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(courseRoot.get("title")),
                    "%" + search.toLowerCase() + "%"));


            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(courseRoot.get("description")),
                    "%" + search.toLowerCase() + "%"));


            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(sectionJoin.get("name")),
                    "%" + search.toLowerCase() + "%"));

            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(lectureJoin.get("name")),
                    "%" + search.toLowerCase() + "%"));

            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(resourceJoin.get("name")),
                    "%" + search.toLowerCase() + "%"));

            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(resourceJoin.get("url")),
                    "%" + search.toLowerCase() + "%"));


            criteriaQuery.select(courseRoot)
                    .where(
                            criteriaBuilder.or(
                                    predicates.toArray(new Predicate[0])
                            )
                    );
            return entityManager.createQuery(criteriaQuery).getResultList();

        }
}
