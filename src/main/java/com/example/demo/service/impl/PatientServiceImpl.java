package com.example.demo.service.impl;

import com.example.demo.dto.PatientDto;
import com.example.demo.entity.Patient;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override

    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = this.mapToEntity(patientDto);
        Patient newPatient = this.patientRepository.save(patient);
        return this.mapToDTO(newPatient);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = this.patientRepository.findAll();
        return patients.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = this.patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        return this.mapToDTO(patient);
    }
    @Override
    public PatientDto updatePatient(PatientDto patientDto, Long id) {
        Patient patient = this.patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        Patient updatedPatient = this.mapToEntity(patientDto);
        updatedPatient.setPatientId(patient.getPatientId());
        Patient savedPatient = this.patientRepository.save(updatedPatient);
        return this.mapToDTO(savedPatient);
    }
    @Override
    public void deletePatientById(Long id) {
        Patient patient = this.patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        this.patientRepository.delete(patient);
    }

    private PatientDto mapToDTO(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setPatientId(patient.getPatientId());
        patientDto.setName(patient.getName());
        patientDto.setPhoneNumber(patient.getPhoneNumber());
        patientDto.setInsuranceInfo(patient.getInsuranceInfo());
        return patientDto;
    }

    private Patient mapToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setPatientId(patientDto.getPatientId());
        patient.setName(patientDto.getName());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setInsuranceInfo(patientDto.getInsuranceInfo());
        return patient;
    }
}