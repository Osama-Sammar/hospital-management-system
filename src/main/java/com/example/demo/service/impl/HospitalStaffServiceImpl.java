package com.example.demo.service.impl;

import com.example.demo.dto.HospitalStaffDto;
import com.example.demo.entity.HospitalStaff;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HospitalStaffRepository;
import com.example.demo.service.HospitalStaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalStaffServiceImpl implements HospitalStaffService {
    private final HospitalStaffRepository hospitalStaffRepository;

    public HospitalStaffServiceImpl(HospitalStaffRepository hospitalStaffRepository) {
        this.hospitalStaffRepository = hospitalStaffRepository;
    }

    public HospitalStaffDto createHospitalStaff(HospitalStaffDto hospitalStaffDto) {
        HospitalStaff hospitalStaff = this.mapToEntity(hospitalStaffDto);
        HospitalStaff newHospitalStaff = this.hospitalStaffRepository.save(hospitalStaff);
        return this.mapToDTO(newHospitalStaff);
    }

    public List<HospitalStaffDto> getAllHospitalStaff() {
        List<HospitalStaff> hospitalStaffList = this.hospitalStaffRepository.findAll();
        return hospitalStaffList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public HospitalStaffDto getHospitalStaffById(Long id) {
        HospitalStaff hospitalStaff = this.hospitalStaffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HospitalStaff", "id", id));
        return this.mapToDTO(hospitalStaff);
    }

    public HospitalStaffDto updateHospitalStaff(HospitalStaffDto hospitalStaffDto, Long id) {
        HospitalStaff hospitalStaff = this.hospitalStaffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HospitalStaff", "id", id));
        HospitalStaff updatedHospitalStaff = this.mapToEntity(hospitalStaffDto);
        updatedHospitalStaff.setHospitalStaffId(hospitalStaff.getHospitalStaffId());
        HospitalStaff savedHospitalStaff = this.hospitalStaffRepository.save(updatedHospitalStaff);
        return this.mapToDTO(savedHospitalStaff);
    }

    public void deleteHospitalStaffById(Long id) {
        HospitalStaff hospitalStaff = this.hospitalStaffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HospitalStaff", "id", id));
        this.hospitalStaffRepository.delete(hospitalStaff);
    }

    private HospitalStaffDto mapToDTO(HospitalStaff hospitalStaff) {
        HospitalStaffDto hospitalStaffDto = new HospitalStaffDto();
        hospitalStaffDto.setHospitalStaffId(hospitalStaff.getHospitalStaffId());
        hospitalStaffDto.setHospitalId(hospitalStaff.getHospitalId());
        hospitalStaffDto.setName(hospitalStaff.getName());
        hospitalStaffDto.setAddress(hospitalStaff.getAddress());
        hospitalStaffDto.setPhoneNum(hospitalStaff.getPhoneNum());
        return hospitalStaffDto;
    }

    private HospitalStaff mapToEntity(HospitalStaffDto hospitalStaffDto) {
        HospitalStaff hospitalStaff = new HospitalStaff();
        hospitalStaff.setHospitalStaffId(hospitalStaffDto.getHospitalStaffId());
        hospitalStaff.setHospitalId(hospitalStaffDto.getHospitalId());
        hospitalStaff.setName(hospitalStaffDto.getName());
        hospitalStaff.setAddress(hospitalStaffDto.getAddress());
        hospitalStaff.setPhoneNum(hospitalStaffDto.getPhoneNum());
        return hospitalStaff;
    }
}