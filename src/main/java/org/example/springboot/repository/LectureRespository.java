package org.example.springboot.repository;

import org.example.springboot.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRespository extends JpaRepository<Lecture, Long> {
}