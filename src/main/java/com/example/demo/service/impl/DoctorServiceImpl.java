//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.service.impl;

import com.example.demo.dto.DoctorDto;
import com.example.demo.entity.Doctor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository DoctorRepository;

    public DoctorServiceImpl(DoctorRepository DoctorRepository) {
        this.DoctorRepository = DoctorRepository;
    }

    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = this.mapToEntity(doctorDto);
        Doctor newDoctor = (Doctor)this.DoctorRepository.save(doctor);
        return this.mapToDTO(newDoctor);
    }

    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = this.DoctorRepository.findAll();
        return (List)doctors.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public DoctorDto getDoctorById(Long id) {
        Doctor doctor = (Doctor)this.DoctorRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Doctor", "id", id);
        });
        return this.mapToDTO(doctor);
    }

    public DoctorDto updateDoctor(DoctorDto doctorDto, Long id) {
        Doctor doctor = (Doctor)this.DoctorRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Doctor", "id", id);
        });
        Doctor updatedDoctor = this.mapToEntity(doctorDto);
        updatedDoctor.setDoctor_id(doctor.getDoctor_id());
        Doctor savedDoctor = (Doctor)this.DoctorRepository.save(updatedDoctor);
        return this.mapToDTO(savedDoctor);
    }

    public void deleteDoctorById(Long id) {
        Doctor doctor = (Doctor)this.DoctorRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Doctor", "id", id);
        });
        this.DoctorRepository.delete(doctor);
    }

    private DoctorDto mapToDTO(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setDoctor_id(doctor.getDoctor_id());
        doctorDto.setDoctorName(doctor.getDoctorName());
        doctorDto.setSpecialty(doctor.getSpecialty());
        doctorDto.setPhoneNum(doctor.getPhoneNum());
        doctorDto.setHospitalId(doctor.getHospitalId());
        return doctorDto;
    }

    private Doctor mapToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setDoctor_id(doctorDto.getDoctor_id());
        doctor.setDoctorName(doctorDto.getDoctorName());
        doctor.setSpecialty(doctorDto.getSpecialty());
        doctor.setPhoneNum(doctorDto.getPhoneNum());
        doctor.setHospitalId(doctorDto.getHospitalId());
        return doctor;
    }
}
