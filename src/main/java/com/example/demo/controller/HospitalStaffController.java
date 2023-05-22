package com.example.demo.controller;
import java.util.List;

import com.example.demo.dto.HospitalStaffDto;
import com.example.demo.service.HospitalStaffService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/hospitalStaff")
public class HospitalStaffController {
    private final HospitalStaffService hospitalStaffService;

    public HospitalStaffController(HospitalStaffService hospitalStaffService) {
        this.hospitalStaffService = hospitalStaffService;
    }

    @GetMapping
    public ResponseEntity<List<HospitalStaffDto>> getAllHospitalStaff() {
        List<HospitalStaffDto> hospitalStaffList = hospitalStaffService.getAllHospitalStaff();
        return ResponseEntity.ok(hospitalStaffList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalStaffDto> getHospitalStaffById(@PathVariable Long id) {
        HospitalStaffDto hospitalStaffDto = hospitalStaffService.getHospitalStaffById(id);
        return ResponseEntity.ok(hospitalStaffDto);
    }

    @PostMapping
    public ResponseEntity<HospitalStaffDto> createHospitalStaff(@RequestBody @Valid HospitalStaffDto hospitalStaffDto) {
        HospitalStaffDto createdHospitalStaff = hospitalStaffService.createHospitalStaff(hospitalStaffDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHospitalStaff);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospitalStaffDto> updateHospitalStaff(
            @PathVariable Long id,
            @RequestBody @Valid HospitalStaffDto hospitalStaffDto
    ) {
        HospitalStaffDto updatedHospitalStaff = hospitalStaffService.updateHospitalStaff(hospitalStaffDto, id);
        return ResponseEntity.ok(updatedHospitalStaff);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHospitalStaff(@PathVariable Long id) {
        hospitalStaffService.deleteHospitalStaffById(id);
        return ResponseEntity.ok("HospitalStaff deleted successfully.");
    }
}