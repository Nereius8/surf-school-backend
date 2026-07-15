package com.escuelasurf.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Surfboard> getAvailableSurfboards() {
        return surfboardRepository.findByIsAvailableTrue();
    }

    @Transactional
    public Surfboard saveSurfboard(Surfboard surfboard) {
        return surfboardRepository.save(surfboard);
    }

    public Optional<Surfboard> getSurfboardById(Long id) {
        return surfboardRepository.findById(id);
    }

    @Transactional
    public void deleteSurfboard(Long id) {
        surfboardRepository.deleteById(id);
    }
}
