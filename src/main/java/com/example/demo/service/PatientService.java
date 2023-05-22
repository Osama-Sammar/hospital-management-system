package com.example.demo.service;

import com.example.demo.dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDto);
    
    List<PatientDto> getAllPatients();
    
    PatientDto getPatientById(Long id);
    
    PatientDto updatePatient(PatientDto patientDto, Long id);
    
    void deletePatientById(Long id);
}