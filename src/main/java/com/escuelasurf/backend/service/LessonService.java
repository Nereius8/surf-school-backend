package com.escuelasurf.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escuelasurf.backend.model.Lesson;
import com.escuelasurf.backend.repository.LessonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LessonService {

    private final LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @Transactional
    public Lesson saveLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }
    
    public Optional<Lesson> getLessonById(Long id) {
        return lessonRepository.findById(id);
    }
    @Transactional
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
