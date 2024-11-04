package org.example.springboot.repository;

import org.example.springboot.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRespository extends JpaRepository<Section, Long> {
}