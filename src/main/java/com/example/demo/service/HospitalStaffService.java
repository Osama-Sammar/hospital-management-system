package com.example.demo.service;

import com.example.demo.dto.HospitalStaffDto;

import java.util.List;

public interface HospitalStaffService {
    HospitalStaffDto createHospitalStaff(HospitalStaffDto hospitalStaffDto);

    List<HospitalStaffDto> getAllHospitalStaff();

    HospitalStaffDto getHospitalStaffById(Long id);

    HospitalStaffDto updateHospitalStaff(HospitalStaffDto hospitalStaffDto, Long id);

    void deleteHospitalStaffById(Long id);
}