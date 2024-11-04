package org.example.springboot.repository;

import org.example.springboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CourseRepository")
public interface CourseRepository extends JpaRepository<Course, Integer> {
//
//
//    List<Course> findByAuthorsId(Long author_id);
//
//    List<Course> findCoursesByAuthorsId(Long author_id);
//
//
//
//  //  List<Course> findCourseByTitleContaining(String title);
//  List<Course> findCourseByTitleContainingIgnoreCase(String title);
//
//
//
//    List<Course> findByTitle(@Param("title") String title);
//
//
//
//
////    @Query("SELECT c FROM Course c JOIN Section s ON s.course = c WHERE s.name = :sectionName")
////    List<Course> findCourseBySectionName(@Param("sectionName") String sectionName);


}
