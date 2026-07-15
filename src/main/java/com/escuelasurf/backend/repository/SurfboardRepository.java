package com.escuelasurf.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuelasurf.backend.model.Surfboard;

public interface SurfboardRepository extends JpaRepository<Surfboard, Long> {
    
    List<Surfboard> findByIsAvailableTrue();
}
