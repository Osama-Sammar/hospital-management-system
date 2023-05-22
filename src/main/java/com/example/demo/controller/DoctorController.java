//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.controller;

import com.example.demo.dto.DoctorDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.DoctorService;
import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping({"/api/doctors"})
public class DoctorController {
    private final Logger log = LoggerFactory.getLogger(DoctorController.class);
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return ResponseEntity.ok().body(this.doctorService.getAllDoctors());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.doctorService.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody @Valid DoctorDto doctorDto) {
        if (doctorDto.getDoctor_id() != null) {
            this.log.error("Cannot have an ID {}", doctorDto);
            throw new BadRequestException(DoctorController.class.getSimpleName(), "Doctor ID");
        } else {
            return new ResponseEntity(this.doctorService.createDoctor(doctorDto), HttpStatus.CREATED);
        }
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody @Valid DoctorDto doctorDto, @PathVariable(name = "id") Long id) {
        return new ResponseEntity(this.doctorService.updateDoctor(doctorDto, id), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> deleteDoctor(@PathVariable(name = "id") Long id) {
        this.doctorService.deleteDoctorById(id);
        return new ResponseEntity("Deleted successfully.", HttpStatus.OK);
    }
}
