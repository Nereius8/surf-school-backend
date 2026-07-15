package com.escuelasurf.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuelasurf.backend.model.Lesson;
import com.escuelasurf.backend.service.LessonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lessons")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor

public class LessonController {
    private final LessonService lessonService;

    @GetMapping
    public List<Lesson> getAll() {
        return lessonService.getAllLessons();
    }

    @PostMapping
    public Lesson create(@RequestBody Lesson lesson) {
        return lessonService.saveLesson(lesson);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getById(@PathVariable Long id) {
        return lessonService.getLessonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.ok().build();
    }
    
}
