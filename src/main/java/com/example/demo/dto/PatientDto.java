package com.example.demo.dto;

import lombok.Data;

@Data
public class PatientDto {
    private Long patientId;
    private String name;
    private int phoneNumber;
    private String insuranceInfo;
    
    // Getters and setters
}