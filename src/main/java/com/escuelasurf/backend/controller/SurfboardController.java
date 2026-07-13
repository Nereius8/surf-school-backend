package com.escuelasurf.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuelasurf.backend.model.Surfboard;
import com.escuelasurf.backend.service.SurfboardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/surfboards")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class SurfboardController {
    
    private final SurfboardService surfboardService;

    @GetMapping
    public List<Surfboard> getAll() {
        return surfboardService.getAllSurfboards();
    }

    @PostMapping
    public Surfboard create(@RequestBody Surfboard surfboard) {
        return surfboardService.saveSurfboard(surfboard);
    }
}