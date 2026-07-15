package com.escuelasurf.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuelasurf.backend.model.Lesson;
import com.escuelasurf.backend.model.LessonLevel;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByLevel(LessonLevel level);
    
}
