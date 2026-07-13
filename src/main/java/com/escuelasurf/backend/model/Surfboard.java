package com.escuelasurf.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table(name = "surfboards") 
@Data 
public class Surfboard {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String model;
    private String type;
    private Double size;
    private Double rentalPricePerHour;
    private Boolean isAvailable;
    
}
