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

import com.escuelasurf.backend.model.Surfboard;
import com.escuelasurf.backend.service.SurfboardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/surfboards")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class SurfboardController {
    
    private final SurfboardService surfboardService;

    // GET: http://localhost:8080/api/surfboards
    @GetMapping
    public List<Surfboard> getAll() {
        return surfboardService.getAllSurfboards();
    }

    // GET: http://localhost:8080/api/surfboards/available
    @GetMapping("/available")
    public List<Surfboard> getAvailable() {
        return surfboardService.getAvailableSurfboards();
    }

    // POST: http://localhost:8080/api/surfboards
    @PostMapping
    public Surfboard create(@RequestBody Surfboard surfboard) {
        return surfboardService.saveSurfboard(surfboard);
    }

    // GET BY ID: http://localhost:8080/api/surfboards/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Surfboard> getById(@PathVariable Long id) {
        return surfboardService.getSurfboardById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: http://localhost:8080/api/surfboards/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (surfboardService.getSurfboardById(id).isPresent()) {
            surfboardService.deleteSurfboard(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}