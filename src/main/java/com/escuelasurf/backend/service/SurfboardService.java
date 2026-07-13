package com.escuelasurf.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.escuelasurf.backend.model.Surfboard;
import com.escuelasurf.backend.repository.SurfboardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SurfboardService {

    private final SurfboardRepository surfboardRepository;

    public List<Surfboard> getAllSurfboards() {
        return surfboardRepository.findAll();
    }

    public Surfboard saveSurfboard(Surfboard surfboard) {
        return surfboardRepository.save(surfboard);
    }
}
